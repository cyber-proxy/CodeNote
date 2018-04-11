package UserPathLogParse;
/**
 * Created by ytq on 2017/1/25.
 */

import java.util.HashMap;

public class NewUserAction{
	
	public final static HashMap<Integer,String> actionDes = new HashMap<Integer,String>(){
		{
			put(ACTION_SPLASH_SMARTLOCK,"splash����������smartlock");
			put(ACTION_TAB_SECURITY,"�����ȫTab");
			put(ACTION_TAB_BOOST,"�������Tab");
			put(ACTION_TAB_CLEAN,"�������Tab");
			put(ACTION_SECURITY_MAIN_CIRCLE,"�����ȫҳ��ԲȦ");
			put(ACTION_SECURITY_MAIN_CHECK_BTN,"�����ȫҳ�水ť");
			put(ACTION_SECURITY_MAIN_WIFI,"�����ȫҳ��WIFIɨ��");
			put(ACTION_SECURITY_MAIN_VIRUS,"�����ȫҳ�没��ɨ��");
			put(ACTION_SECURITY_MAIN_MALWARE,"�����ȫҳ�����ɨ��");
			put(ACTION_SECURITY_MAIN_PERMISSION,"�����ȫҳ����˽����");
			put(ACTION_SECURITY_MAIN_APPLOCKER,"�����ȫҳ��Ӧ����");
			put(ACTION_SECURITY_MAIN_AD,"�����ȫҳ����");
			put(ACTION_SECURITY_ONE_TAP_SOLVE_PROBLEM,"������ҳһ�����");
			put(ACTION_BOOST_MAIN_CIRCLE,"�������ҳ��ԲȦ");
			put(ACTION_BOOST_MAIN_BOOST_BTN,"�������ҳ�水ť");
			put(ACTION_BOOST_MAIN_SAVE_BATTERY,"�������ҳ���̨�ĵ�");
			put(ACTION_BOOST_MAIN_TEMPERATURE,"�������ҳ��CPU����");
			put(ACTION_BOOST_MAIN_SMART_LOCK,"�������ҳ��Smart Locker");
			put(ACTION_BOOST_MAIN_INSTANT_BATTERY,"�������ҳ��ʵʱ�ĵ�");
			put(ACTION_BOOST_MAIN_AD,"�������ҳ����");
			put(ACTION_CLEAN_MAIN_CIRCLE,"�������ҳ��ԲȦ");
			put(ACTION_CLEAN_MAIN_CLEAN_BTN,"�������ҳ�水ť");
			put(ACTION_CLEAN_MAIN_NETWORK,"�������ҳ���������");
			put(ACTION_CLEAN_MAIN_CPU,"�������ҳ��ʵʱCPU��Ϣ");
			put(ACTION_DRAWER_WIFI,"��������WiFiɨ��");
			put(ACTION_DRAWER_BATTERY,"��������ʡ��");
			put(ACTION_DRAWER_BATTERY_USAGE_RANK,"���������õ�������");
			put(ACTION_DRAWER_COOLER,"��������CPU����");
			put(ACTION_DRAWER_APPLOCKER,"��������Ӧ����");
			put(ACTION_DRAWER_NOTIFICATION,"��������֪ͨ����");
			put(ACTION_DRAWER_SETTING,"������������");
			put(ACTION_DRAWER_ABOUT,"��������About");
			put(ACTION_DRAWER_FAMILY,"��������Family");
			put(ACTION_LOCKER_PERMISSION,"Ӧ����Ҫ���Ȩ������");
			put(ACTION_LOCKER_SET_PASSWORD,"Ӧ������������");
			put(ACTION_LOCKER_LOCK_APP_ITEM,"���Ӧ������");
			put(ACTION_LOCKER_LOCK_CARD_CLICK,"���Ӧ�����ϵĿ�Ƭ");
			put(ACTION_LOCKER_LOCK_MENU_CLICK,"���Ӧ�������ð�ť");
			put(ACTION_LOCKER_LOCK_EMAIL_SEND_CLICK,"���Ӧ����Email����ȷ�ϰ�ť");
			put(ACTION_SAVE_BATTERY_SAVE_BTN,"���ʡ��ҳ��ʡ�簴ť");
			put(ACTION_SAVE_BATTERY_WHITELIST_CLICKED,"���ʡ��ҳ����Ӱ�����ͼ��");
			put(ACTION_SAVE_BATTERY_WHITELIST_ITEM_CLICKED,"���ʡ���������������ɾ��ͼ��");
			put(ACTION_SAVE_BATTERY_ADD_WHITELIST_CLICKED,"���ʡ�������ҳ�����ͼ��");
			put(ACTION_SAVE_BATTERY_ADD_WHITELIST_ITEM_CLICKED, "���ʡ������������������ͼ��");
			put(ACTION_INSTANT_BATTERY_ITEM_CLICKED,"ʵʱ�ĵ�ҳ�浥����");
			put(ACTION_APP_STOP,"���Ӧ������ҳ��ֹͣ��ť");
			put(ACTION_APP_UNINSTALL,"���Ӧ������ҳ��ж�ذ�ť");
			put(ACTION_SETTING_SMARTLOCK,"�������ҳ���Smart Lock");
			put(ACTION_SETTING_WIFI_CHECK,"�������ҳ���WiFi��������");
			put(ACTION_SETTING_LANGUAGE,"�������ҳ�������");
			put(ACTION_SETTING_UNKNOW_APP_CHECK,"�������ҳ���δ֪��Դ���");
			put(ACTION_CLEAN_CHECKBOX_CHANGE,"�����������ҳ��Ĺ�ѡ��");
			put(ACTION_CLEAN_BTN_CLICKED,"�����������ҳ�������ť");
			put(ACTION_NETWORK_ITEM_CLICKED,"����������ҳ�����");
			put(ACTION_CPU_ITEM_CLICKED,"���ʵʱCPU��Ϣҳ�����");
			put(ACTION_NOTIFICATION_GET_PERMISSION,"�����ȡ֪ͨ����Ȩ��");
			put(ACTION_NOTIFICATION_CLEAN_ALL,"���֪ͨ����Clear All");
			put(ACTION_NOTIFICATION_SETTING,"���֪ͨ��������ͼ��");
			put(ACTION_NOTIFICATION_ALWAYS_NOTIFICATION_BAR_CLICKED,"�����פ֪ͨ������");
			put(ACTION_NOTIFICATION_ITEM_CLEAN_CLICKED,"�������֪ͨ��");
			put(ACTION_NOTIFICATION_STOP,"���ֹ֪ͣͨ����");
			put(ACTION_NOTIFICATION_MENU_CLICKED,"���֪ͨ�������ò˵�");
			put(ACTION_NOTIFICATION_ITEM_ALLOW_CLICKED,"���֪ͨ����������");
			put(ACTION_NOTIFICATION_ITEM_DISALLOW_CLICKED,"���֪ͨ�������ֹ");
			put(ACTION_HOME_KEY_CLICKED,"���Home");
			put(ACTION_BACK_KEY_MAIN_CLICKED,"������ϽǷ���ͼ��");
			put(ACTION_BACK_KEY_QUIT_PRODUCT_RECOMMEND_CLICKED,"������ذ�ť�˳���Ʒ�Ƽ�ҳ��");
			put(ACTION_FAMILY_ITEM_CLICKED,"���Family��");
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
