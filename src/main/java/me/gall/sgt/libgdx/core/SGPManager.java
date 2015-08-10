package me.gall.sgt.libgdx.core;

import java.lang.reflect.Method;
import java.util.Map;

import me.gall.sgp.sdk.entity.Server;
import me.gall.sgp.sdk.entity.User;
import me.gall.sgp.sdk.service.AchievementService;
import me.gall.sgp.sdk.service.AnnouncementService;
import me.gall.sgp.sdk.service.BlacklistService;
import me.gall.sgp.sdk.service.BossService;
import me.gall.sgp.sdk.service.CampaignService;
import me.gall.sgp.sdk.service.CheckinBoardService;
import me.gall.sgp.sdk.service.CheckinService;
import me.gall.sgp.sdk.service.DailyTaskService;
import me.gall.sgp.sdk.service.DelegateDidService;
import me.gall.sgp.sdk.service.FileStorageService;
import me.gall.sgp.sdk.service.FriendshipExtraService;
import me.gall.sgp.sdk.service.FriendshipService;
import me.gall.sgp.sdk.service.GachaBoxService;
import me.gall.sgp.sdk.service.GiftCodeService;
import me.gall.sgp.sdk.service.InvitationCodeService;
import me.gall.sgp.sdk.service.LeaderBoardService;
import me.gall.sgp.sdk.service.MailService;
import me.gall.sgp.sdk.service.NotificationService;
import me.gall.sgp.sdk.service.PlayerExtraService;
import me.gall.sgp.sdk.service.PrivateChannelService;
import me.gall.sgp.sdk.service.PublicChannelService;
import me.gall.sgp.sdk.service.RouterService;
import me.gall.sgp.sdk.service.SgpPlayerService;
import me.gall.sgp.sdk.service.StoreService;
import me.gall.sgp.sdk.service.StructuredDataService;
import me.gall.sgp.sdk.service.TicketService;
import me.gall.sgp.sdk.service.TimestampService;
import me.gall.sgp.sdk.service.UserService;
import me.gall.sgt.java.core.PlatformNetworkStateListener;
import me.gall.sgt.java.core.SGTContext;
import me.gall.sgt.java.core.SGTManager;
import me.gall.sgt.java.core.SGTServiceInterface;

import org.joor.Reflect;
import org.joor.ReflectException;
import org.slf4j.Logger;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public final class SGPManager implements SGTServiceInterface,
		PlatformNetworkStateListener {

	private SGTManager sgtManager;

	public static SGPManager getInstance(String appId, boolean sandbox) {
		return getInstance(appId, sandbox, false);
	}

	public static SGPManager getInstance(SGTContext sgtContext) {
		SGTManager sgtManager = SGTManager.getInstance(sgtContext);
		SGPManager sgpManager = new SGPManager();
		sgpManager.sgtManager = sgtManager;
		sgtManager.setPlatformNetworkStateListener(sgpManager);
		return sgpManager;
	}

	public static SGPManager getInstance(String appId, boolean sandbox,
			boolean offlineMode) {
		return getInstance(appId, null, null, sandbox, offlineMode);
	}

	public static SGPManager getInstance(String appId, String appKey,
			String appSecret, boolean sandbox, boolean offlineMode) {
		return getInstance(SGTContext.constructSGTContext(appId, appKey,
				appSecret, sandbox, offlineMode));
	}

	private static Object androidContext;

	public static void setAndroidContext(Object object) {
		androidContext = object;
	}

	@Override
	public SGTContext getSgtContext() {
		// TODO Auto-generated method stub
		return sgtManager.getSgtContext();
	}

	@Override
	public void setSgtContext(SGTContext sgtContext) {
		// TODO Auto-generated method stub
		sgtManager.setSgtContext(sgtContext);
	}

	@Override
	public String getAppId() {
		// TODO Auto-generated method stub
		return sgtManager.getAppId();
	}

	@Override
	public boolean isOfflineMode() {
		// TODO Auto-generated method stub
		return sgtManager.isOfflineMode();
	}

	@Override
	public int getRequestTimeout() {
		// TODO Auto-generated method stub
		return sgtManager.getRequestTimeout();
	}

	@Override
	public Server getCurrentServer() {
		// TODO Auto-generated method stub
		return sgtManager.getCurrentServer();
	}

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return sgtManager.getCurrentUser();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		sgtManager.init();
	}

	@Override
	public RouterService getRouterService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getRouterService();
	}

	@Override
	public UserService getUserService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getUserService();
	}

	@Override
	public AnnouncementService getAnnouncementService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getAnnouncementService();
	}

	@Override
	public SgpPlayerService getSgpPlayerService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getSgpPlayerService();
	}

	@Override
	public LeaderBoardService getLeaderBoardService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getLeaderBoardService();
	}

	@Override
	public MailService getMailService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getMailService();
	}

	@Override
	public FriendshipService getFriendshipService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getFriendshipService();
	}

	@Override
	public CheckinService getCheckinService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getCheckinService();
	}

	@Override
	public CampaignService getCampaignService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getCampaignService();
	}

	@Override
	public BossService getBossService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getBossService();
	}

	@Override
	public GachaBoxService getGachaBoxService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getGachaBoxService();
	}

	@Override
	public BlacklistService getBlacklistService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getBlacklistService();
	}

	@Override
	public StructuredDataService getStructuredDataService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getStructuredDataService();
	}

	@Override
	public TicketService getTicketService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getTicketService();
	}

	@Override
	public DelegateDidService getDelegateDidService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getDelegateDidService();
	}

	@Override
	public PlayerExtraService getPlayerExtraService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getPlayerExtraService();
	}

	@Override
	public PrivateChannelService getPrivateChannelService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getPrivateChannelService();
	}

	@Override
	public PublicChannelService getPublicChannelService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getPublicChannelService();
	}

	@Override
	public StoreService getStoreService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getStoreService();
	}

	@Override
	public User login(String username, String password) throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.login(username, password);
	}

	@Override
	public Server updateRouting(Map<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.updateRouting(params);
	}

	@Override
	public void setCurrentUser(User user) {
		// TODO Auto-generated method stub
		sgtManager.setCurrentUser(user);
	}

	@Override
	public <T> T getService(Class<T> clazz) throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getService(clazz);
	}

	@Override
	public Server routeByChannel(String channel) throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.routeByChannel(channel);
	}

	@Override
	public boolean hasInternetConnection() {
		// TODO Auto-generated method stub
		if (Gdx.app == null) {
			getLogger().error("Gdx.app must be initilized at first.");
			return false;
		}
		if (Gdx.app.getType() == ApplicationType.Android) {
			if (androidContext == null) {
				getLogger()
						.error("Must call setAndroidContext() in your Activity.onCreate() at first.");
				return true;
			} else {
				Reflect connectivityManager = Reflect.on(androidContext).call(
						"getSystemService", "connectivity");
				boolean wifi = false;
				try {
					wifi = connectivityManager.call("getNetworkInfo", 1)
							.call("isConnectedOrConnecting").get();
				} catch (ReflectException e) {
					getLogger().warn(e.getMessage());
				}
				boolean mobile = false;
				try {
					mobile = connectivityManager.call("getNetworkInfo", 0)
							.call("isConnectedOrConnecting").get();
				} catch (ReflectException e) {
					getLogger().warn(e.getMessage());
				}
				return wifi || mobile;
			}
		} else if (Gdx.app.getType() == ApplicationType.Desktop) {
			try {
				String ping = "ping "
						+ (OS.indexOf("win") == -1 ? "-c 1 " : "-n 1 ")
						+ NETWORK_PING_IP;
				Process process = java.lang.Runtime.getRuntime().exec(ping);
				int returnVal = process.waitFor();
				return (returnVal == 0);
			} catch (Exception e) {
				getLogger().warn(e.getMessage());
				return true;
			}
		} else if (Gdx.app.getType() == ApplicationType.iOS) {
			// getLogger().warn("Oooops, hasInternetConnection() has not been implement on ios.");
			try {
				Class SCNetworkReachability = Class
						.forName("org.robovm.apple.systemconfiguration.SCNetworkReachability");
				Method create = SCNetworkReachability.getMethod("create",
						String.class);
				Object reachability = create.invoke(null, "www.baidu.com");
				Method getFlags = SCNetworkReachability.getMethod("getFlags");
				Object flag = getFlags.invoke(reachability);
				Object None = flag.getClass().getField("None").get(null);
				// System.out.println("flag: " +
				// flag.getClass().getMethod("value").invoke(flag) + ", None: "
				// + None.getClass().getMethod("value").invoke(None));
				return !None.equals(flag);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}

	private static final String OS = System.getProperty("os.name")
			.toLowerCase();
	private static final String NETWORK_PING_IP = "114.114.114.114";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		sgtManager.destroy();
	}

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return sgtManager.getLogger();
	}

	@Override
	public AchievementService getAchievementService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getAchievementService();
	}

	@Override
	public DailyTaskService getDailyTaskService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getDailyTaskService();
	}

	@Override
	public FileStorageService getFileStorageService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getFileStorageService();
	}

	@Override
	public FriendshipExtraService getFriendshipExtraService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getFriendshipExtraService();
	}

	@Override
	public GiftCodeService getGiftCodeService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getGiftCodeService();
	}

	@Override
	public NotificationService getNotificationService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getNotificationService();
	}

	@Override
	public User signup(String username, String password) throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.signup(username, password);
	}

	@Override
	public TimestampService getTimestampService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getTimestampService();
	}

	@Override
	public CheckinBoardService getCheckinBoardService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getCheckinBoardService();
	}

	public static final String DEFAULT_PASSWORD = "000000";
	public static final String SGT_TEMP_ACCOUNT_FILE = "_SGT_TEMP_ACCOUNT_FILE_";
	public static final int MAX_RETRY_TIME = 3;

	private int quickLoginRetryTimes = 0;

	@Override
	public User quickLogin() throws Throwable {
		// TODO Auto-generated method stub
		if (!Gdx.files.isLocalStorageAvailable()) {
			throw new Exception(
					"Local file storage is not available. Could not quick login now.");
		}
		User user = null;
		FileHandle handle = Gdx.files.local(SGT_TEMP_ACCOUNT_FILE);
		if (handle.exists()) {
			try {
				String username = handle.readString();
				getLogger().debug("Find quick login username:" + username);
				user = login(username, DEFAULT_PASSWORD);
			} catch (Exception e) {
				throw e;
			}
		} else {
			try {
				String username = generateRandomUsername();
				getLogger().debug(
						"Miss quick login username, generate new username:"
								+ username);
				user = signup(username, DEFAULT_PASSWORD);
				handle.writeString(username, false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				if (quickLoginRetryTimes < MAX_RETRY_TIME) {
					getLogger().warn(
							"Quick login fail for " + e + ", now trying "
									+ quickLoginRetryTimes + " times.");
					quickLoginRetryTimes++;
					quickLogin();
				} else {
					quickLoginRetryTimes = 0;
					throw e;
				}
			}
		}
		return user;
	}

	private String generateRandomUsername() {
		return getAppId() + "_"
				+ String.valueOf(System.currentTimeMillis()).substring(5);
	}

	@Override
	public InvitationCodeService getInvitationCodeService() throws Throwable {
		// TODO Auto-generated method stub
		return sgtManager.getInvitationCodeService();
	}

}
