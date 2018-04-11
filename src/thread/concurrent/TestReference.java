package thread.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import SelfUtil.Debug;

public class TestReference {

    // for display page
    private static HashMap<String, List<String>> mBlockNotifyMap = new HashMap<>();
    // for charging page
    private static HashMap<String, List<String>> mRecurNotifyMap = new HashMap<>();
    
	public static void main(String[] args) {
		Thread setThread = new Thread(new setJob());
		setThread.start();
		Thread getThread = new Thread(new getJob());
		getThread.start();
	}
	
	public static class setJob implements Runnable{
		public void run() {
			for(;;){
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setBlockPackages();
			}
		}
	};
	
	public static class getJob implements Runnable{
		public void run() {
			for(;;){
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getDataList("asd", true);
			}
		}
	};

    public static List<String> setBlockPackages(){
//        synchronized (mBlockNotifyMap){
        	List<String> value = new ArrayList<>();
			mBlockNotifyMap.put("asdf", value);
            List<String> list = new ArrayList<>();
            list.addAll(mBlockNotifyMap.keySet());
            return list;
//        }
    }

    public static ArrayList<String> getDataList(String pkg, Boolean cacheType){
        HashMap<String, List<String>> notifyMap;
        if (cacheType){
            notifyMap = mBlockNotifyMap;
        } else {
            notifyMap = mRecurNotifyMap;
        }
        synchronized (notifyMap){
            ArrayList<String> list = new ArrayList<>();
            list.addAll(notifyMap.get(pkg));
            return list;
        }
    }
      

}
