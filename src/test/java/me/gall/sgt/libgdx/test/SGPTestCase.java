
package me.gall.sgt.libgdx.test;

import java.util.HashMap;

import me.gall.sgp.node.exception.SgpException;
import me.gall.sgp.node.exception.SgpPlayerNotFoundException;
import me.gall.sgp.sdk.entity.Server;
import me.gall.sgp.sdk.entity.User;
import me.gall.sgp.sdk.entity.app.SgpPlayer;
import me.gall.sgp.sdk.service.RouterService;
import me.gall.sgp.sdk.service.SgpPlayerService;
import me.gall.sgt.java.core.NetworkNotAvailableException;
import me.gall.sgt.libgdx.core.SGPManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class SGPTestCase {

    private LwjglApplication app;

    @Before
    public void prepare() {
        if (app == null) {
            LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
            app = new LwjglApplication(new ApplicationListener() {

                @Override
                public void resume() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void resize(int width, int height) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void render() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void pause() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void dispose() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void create() {
                    // TODO Auto-generated method stub

                }
            }, config);
        }

        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    /**
     * 二次分服测试
     * 
     * @version 1.0
     * @author 黄承开 update 2014年4月28日 上午11:02:20
     */
    @Test
    public void mainTest() {
        try {
            SGPManager manager = SGPManager.getInstance("zsd_sgp", true, false);
            manager.getSgtContext().setRequestTimeout(5000);
            User user = manager.login("SdkTest2", "abcd1234");
            // System.out.println(user.getImei());
            // Assert.assertEquals(user.getImei(), device.getDeviceIMEI());
            HashMap<String, String> params = new HashMap<String, String>();
            params.put(RouterService.APP_SIGN, null);
            params.put(RouterService.CHANNEL_ID, "zsdDEBUG");
            params.put(RouterService.USER_ID, user.getUserid());
            params.put(RouterService.CREATE_TIME, String.valueOf(user.getCreateTime()));
            Server server = manager.updateRouting(params);
            Assert.assertNotNull(server);
            manager = SGPManager.getInstance("zsd_game", true, false);
            // user = manager.login("SdkTest2", "abcd1234");
            // System.out.println(user.getImei());
            // Assert.assertEquals(user.getImei(), device.getDeviceIMEI());
            params = new HashMap<String, String>();
            params.put(RouterService.APP_SIGN, null);
            params.put(RouterService.CHANNEL_ID, "zsdDEBUG");
            // params.put(RouterService.USER_ID, user.getUserid());
            params.put(RouterService.CREATE_TIME, String.valueOf(user.getCreateTime()));
            server = manager.updateRouting(params);
            Assert.assertNotNull(server);
            manager.getLogger().debug(server.getAddress());
        } catch (NetworkNotAvailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SgpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testUserLogin() {
        try {
            SGPManager manager = SGPManager.getInstance("xmj2_sgt", true, false);
            User user = manager.login("zhangzhe", "zhangzhe");
            manager.getLogger().debug(user.getUserid());
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testQuickLogin() {
        try {
            SGPManager manager = SGPManager.getInstance("xmj2_sgt", true, false);
            User user = manager.quickLogin();
            manager.getLogger().debug(user.getUserName() + "   " + user.getUserid());
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 测试Player的实体版本兼容性
     * 
     * @version 1.0
     * @author 黄承开 update 2014年4月28日 上午11:04:09
     */
    @Test
    public void testPlayerVersionCompitiable() {
        // context = new Context();
        try {
            SGPManager manager = SGPManager.getInstance("zsd_sgp", true, false);
            User user = manager.login("panjinghao", "123456");
            // System.out.println(user.getImei());
            // Assert.assertEquals(user.getImei(), device.getDeviceIMEI());
            HashMap<String, String> params = new HashMap<String, String>();
            params.put(RouterService.APP_SIGN, null);
            params.put(RouterService.CHANNEL_ID, "zsdDEBUG");
            params.put(RouterService.USER_ID, user.getUserid());
            params.put(RouterService.CREATE_TIME, String.valueOf(user.getCreateTime()));
            Server server = manager.updateRouting(params);
            Assert.assertNotNull(server);
            // manager = SGPManager.getInstance(context, "zsd_game", true,
            // false);
            // user = manager.login("SdkTest2", "abcd1234");
            // System.out.println(user.getImei());
            // Assert.assertEquals(user.getImei(), device.getDeviceIMEI());
            // params = new HashMap<String, String>();
            // params.put(RouterService.APP_SIGN, null);
            // params.put(RouterService.CHANNEL_ID, "zsdDEBUG");
            // // params.put(RouterService.USER_ID, user.getUserid());
            // params.put(RouterService.CREATE_TIME,
            // String.valueOf(user.getCreateTime()));
            // server = manager.updateRouting(params);
            // Assert.assertNotNull(server);
            // user= userService .register("IMEI00123456789", "Fake-ICCID",
            // "Fake-Mac");
            SgpPlayerService sgpPlayerService = manager.getSgpPlayerService();
            // sgpPlayerService.searchPlayersByLastLogin(1,10,new String[]{""});
            SgpPlayer[] s = sgpPlayerService.getByUserId(user.getUserid());
            for (SgpPlayer ss : s) {
                manager.getSgtContext().getLogger().debug(ss.getId());
            }

        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @After
    public void clean() {
        app.exit();
    }

}
