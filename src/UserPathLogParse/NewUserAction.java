package UserPathLogParse;
/**
 * Created by ytq on 2017/1/25.
 */

import java.util.HashMap;

public class NewUserAction{
	
	public final static HashMap<Integer,String> actionDes = new HashMap<Integer,String>(){
		{
			put(ACTION_SPLASH_SMARTLOCK,"splash界面点击开启smartlock");
			put(ACTION_TAB_SECURITY,"点击安全Tab");
			put(ACTION_TAB_BOOST,"点击加速Tab");
			put(ACTION_TAB_CLEAN,"点击清理Tab");
			put(ACTION_SECURITY_MAIN_CIRCLE,"点击安全页面圆圈");
			put(ACTION_SECURITY_MAIN_CHECK_BTN,"点击安全页面按钮");
			put(ACTION_SECURITY_MAIN_WIFI,"点击安全页面WIFI扫描");
			put(ACTION_SECURITY_MAIN_VIRUS,"点击安全页面病毒扫描");
			put(ACTION_SECURITY_MAIN_MALWARE,"点击安全页面恶意扫描");
			put(ACTION_SECURITY_MAIN_PERMISSION,"点击安全页面隐私顾问");
			put(ACTION_SECURITY_MAIN_APPLOCKER,"点击安全页面应用锁");
			put(ACTION_SECURITY_MAIN_AD,"点击安全页面广告");
			put(ACTION_SECURITY_ONE_TAP_SOLVE_PROBLEM,"点击结果页一键解决");
			put(ACTION_BOOST_MAIN_CIRCLE,"点击加速页面圆圈");
			put(ACTION_BOOST_MAIN_BOOST_BTN,"点击加速页面按钮");
			put(ACTION_BOOST_MAIN_SAVE_BATTERY,"点击加速页面后台耗电");
			put(ACTION_BOOST_MAIN_TEMPERATURE,"点击加速页面CPU降温");
			put(ACTION_BOOST_MAIN_SMART_LOCK,"点击加速页面Smart Locker");
			put(ACTION_BOOST_MAIN_INSTANT_BATTERY,"点击加速页面实时耗电");
			put(ACTION_BOOST_MAIN_AD,"点击加速页面广告");
			put(ACTION_CLEAN_MAIN_CIRCLE,"点击清理页面圆圈");
			put(ACTION_CLEAN_MAIN_CLEAN_BTN,"点击清理页面按钮");
			put(ACTION_CLEAN_MAIN_NETWORK,"点击清理页面网络分析");
			put(ACTION_CLEAN_MAIN_CPU,"点击清理页面实时CPU信息");
			put(ACTION_DRAWER_WIFI,"点击侧边栏WiFi扫描");
			put(ACTION_DRAWER_BATTERY,"点击侧边栏省电");
			put(ACTION_DRAWER_BATTERY_USAGE_RANK,"点击侧边栏用电量排行");
			put(ACTION_DRAWER_COOLER,"点击侧边栏CPU降温");
			put(ACTION_DRAWER_APPLOCKER,"点击侧边栏应用锁");
			put(ACTION_DRAWER_NOTIFICATION,"点击侧边栏通知管理");
			put(ACTION_DRAWER_SETTING,"点击侧边栏设置");
			put(ACTION_DRAWER_ABOUT,"点击侧边栏About");
			put(ACTION_DRAWER_FAMILY,"点击侧边栏Family");
			put(ACTION_LOCKER_PERMISSION,"应用锁要求的权限设置");
			put(ACTION_LOCKER_SET_PASSWORD,"应用锁设置密码");
			put(ACTION_LOCKER_LOCK_APP_ITEM,"点击应用锁项");
			put(ACTION_LOCKER_LOCK_CARD_CLICK,"点击应用锁上的卡片");
			put(ACTION_LOCKER_LOCK_MENU_CLICK,"点击应用锁设置按钮");
			put(ACTION_LOCKER_LOCK_EMAIL_SEND_CLICK,"点击应用锁Email设置确认按钮");
			put(ACTION_SAVE_BATTERY_SAVE_BTN,"点击省电页面省电按钮");
			put(ACTION_SAVE_BATTERY_WHITELIST_CLICKED,"点击省电页面添加白名单图标");
			put(ACTION_SAVE_BATTERY_WHITELIST_ITEM_CLICKED,"点击省电白名单待添加项的删除图标");
			put(ACTION_SAVE_BATTERY_ADD_WHITELIST_CLICKED,"点击省电白名单页面添加图标");
			put(ACTION_SAVE_BATTERY_ADD_WHITELIST_ITEM_CLICKED, "点击省电白名单待添加项的添加图标");
			put(ACTION_INSTANT_BATTERY_ITEM_CLICKED,"实时耗电页面单项点击");
			put(ACTION_APP_STOP,"点击应用详情页面停止按钮");
			put(ACTION_APP_UNINSTALL,"点击应用详情页面卸载按钮");
			put(ACTION_SETTING_SMARTLOCK,"点击设置页面的Smart Lock");
			put(ACTION_SETTING_WIFI_CHECK,"点击设置页面的WiFi风险提醒");
			put(ACTION_SETTING_LANGUAGE,"点击设置页面的语言");
			put(ACTION_SETTING_UNKNOW_APP_CHECK,"点击设置页面的未知来源检测");
			put(ACTION_CLEAN_CHECKBOX_CHANGE,"点击垃圾清理页面的勾选框");
			put(ACTION_CLEAN_BTN_CLICKED,"点击垃圾清理页面的清理按钮");
			put(ACTION_NETWORK_ITEM_CLICKED,"点击网络分析页面的项");
			put(ACTION_CPU_ITEM_CLICKED,"点击实时CPU信息页面的项");
			put(ACTION_NOTIFICATION_GET_PERMISSION,"点击获取通知管理权限");
			put(ACTION_NOTIFICATION_CLEAN_ALL,"点击通知管理Clear All");
			put(ACTION_NOTIFICATION_SETTING,"点击通知管理设置图标");
			put(ACTION_NOTIFICATION_ALWAYS_NOTIFICATION_BAR_CLICKED,"点击常驻通知栏开关");
			put(ACTION_NOTIFICATION_ITEM_CLEAN_CLICKED,"点击清理通知项");
			put(ACTION_NOTIFICATION_STOP,"点击停止通知管理");
			put(ACTION_NOTIFICATION_MENU_CLICKED,"点击通知管理设置菜单");
			put(ACTION_NOTIFICATION_ITEM_ALLOW_CLICKED,"点击通知管理项允许");
			put(ACTION_NOTIFICATION_ITEM_DISALLOW_CLICKED,"点击通知管理项禁止");
			put(ACTION_HOME_KEY_CLICKED,"点击Home");
			put(ACTION_BACK_KEY_MAIN_CLICKED,"点击左上角返回图标");
			put(ACTION_BACK_KEY_QUIT_PRODUCT_RECOMMEND_CLICKED,"点击返回按钮退出产品推荐页面");
			put(ACTION_FAMILY_ITEM_CLICKED,"点击Family项");
		}
	};
	
    public static final int ACTION_SPLASH_SMARTLOCK = 0;
    public static final int ACTION_TAB_SECURITY = 1;
    public static final int ACTION_TAB_BOOST = 2;
    public static final int ACTION_TAB_CLEAN = 3;
    public static final int ACTION_SECURITY_MAIN_CIRCLE = 4;
    public static final int ACTION_SECURITY_MAIN_CHECK_BTN = 5;
    public static final int ACTION_SECURITY_MAIN_WIFI = 6;
    public static final int ACTION_SECURITY_MAIN_VIRUS = 7;
    public static final int ACTION_SECURITY_MAIN_MALWARE = 8;
    public static final int ACTION_SECURITY_MAIN_PERMISSION = 9;
    public static final int ACTION_SECURITY_MAIN_APPLOCKER = 10;
    public static final int ACTION_SECURITY_MAIN_AD = 11;
    public static final int ACTION_SECURITY_ONE_TAP_SOLVE_PROBLEM = 12;
    public static final int ACTION_BOOST_MAIN_CIRCLE = 13;
    public static final int ACTION_BOOST_MAIN_BOOST_BTN = 14;
    public static final int ACTION_BOOST_MAIN_SAVE_BATTERY = 15;
    public static final int ACTION_BOOST_MAIN_TEMPERATURE = 16;
    public static final int ACTION_BOOST_MAIN_SMART_LOCK = 17;
    public static final int ACTION_BOOST_MAIN_INSTANT_BATTERY = 18;
    public static final int ACTION_BOOST_MAIN_AD = 19;
    public static final int ACTION_CLEAN_MAIN_CIRCLE = 20;
    public static final int ACTION_CLEAN_MAIN_CLEAN_BTN = 21;
    public static final int ACTION_CLEAN_MAIN_NETWORK = 22;
    public static final int ACTION_CLEAN_MAIN_CPU = 23;
    public static final int ACTION_DRAWER_WIFI = 24;
    public static final int ACTION_DRAWER_BATTERY = 25;
    public static final int ACTION_DRAWER_BATTERY_USAGE_RANK = 26;
    public static final int ACTION_DRAWER_COOLER = 27;
    public static final int ACTION_DRAWER_APPLOCKER = 28;
    public static final int ACTION_DRAWER_NOTIFICATION = 29;
    public static final int ACTION_DRAWER_SETTING = 30;
    public static final int ACTION_DRAWER_ABOUT = 31;
    public static final int ACTION_DRAWER_FAMILY = 32;

    public static final int ACTION_LOCKER_PERMISSION = 33;
    public static final int ACTION_LOCKER_SET_PASSWORD = 34;
    public static final int ACTION_LOCKER_LOCK_APP_ITEM = 35;
    public static final int ACTION_LOCKER_LOCK_CARD_CLICK = 36;
    public static final int ACTION_LOCKER_LOCK_MENU_CLICK = 37;
    public static final int ACTION_LOCKER_LOCK_EMAIL_SEND_CLICK = 38;

    public static final int ACTION_SAVE_BATTERY_SAVE_BTN = 39;
    public static final int ACTION_SAVE_BATTERY_WHITELIST_CLICKED = 40;//
    public static final int ACTION_SAVE_BATTERY_WHITELIST_ITEM_CLICKED = 41;
    public static final int ACTION_SAVE_BATTERY_ADD_WHITELIST_CLICKED = 42;//
    public static final int ACTION_SAVE_BATTERY_ADD_WHITELIST_ITEM_CLICKED = 43;//

    public static final int ACTION_INSTANT_BATTERY_ITEM_CLICKED = 44;//
    public static final int ACTION_APP_STOP = 45;//
    public static final int ACTION_APP_UNINSTALL = 46;//

    public static final int ACTION_SETTING_SMARTLOCK = 47;
    public static final int ACTION_SETTING_WIFI_CHECK = 48;
    public static final int ACTION_SETTING_LANGUAGE = 49;
    public static final int ACTION_SETTING_UNKNOW_APP_CHECK = 50;

    public static final int ACTION_CLEAN_CHECKBOX_CHANGE = 51;
    public static final int ACTION_CLEAN_BTN_CLICKED = 52;

    public static final int ACTION_NETWORK_ITEM_CLICKED = 53;

    public static final int ACTION_CPU_ITEM_CLICKED = 56;

    public static final int ACTION_NOTIFICATION_GET_PERMISSION = 59;//
    public static final int ACTION_NOTIFICATION_CLEAN_ALL = 60;//
    public static final int ACTION_NOTIFICATION_SETTING = 61;//
    public static final int ACTION_NOTIFICATION_ALWAYS_NOTIFICATION_BAR_CLICKED = 62;//
    public static final int ACTION_NOTIFICATION_ITEM_CLEAN_CLICKED = 63;//
    public static final int ACTION_NOTIFICATION_STOP = 64;//
    public static final int ACTION_NOTIFICATION_MENU_CLICKED = 65;//
    public static final int ACTION_NOTIFICATION_ITEM_ALLOW_CLICKED = 69;//
    public static final int ACTION_NOTIFICATION_ITEM_DISALLOW_CLICKED = 70;//

    public static final int ACTION_HOME_KEY_CLICKED = 71;//
    public static final int ACTION_BACK_KEY_MAIN_CLICKED = 72;//
    public static final int ACTION_BACK_KEY_QUIT_PRODUCT_RECOMMEND_CLICKED = 73;//

    public static final int ACTION_FAMILY_ITEM_CLICKED = 66;//

    //new user action key end
}
