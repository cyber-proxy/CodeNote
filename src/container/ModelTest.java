package container;

import java.util.ArrayList;

import SelfUtil.Debug;

public class ModelTest {

    private static final int LIMIT_OF_WIFI_ACCESS_TIME = 3;
	public ArrayList<String> riskPkgList = new ArrayList<>();
    public ArrayList<Long> wifiAccessTimeList = new ArrayList<>();
    public ArrayList<Integer> permissionAddedList = new ArrayList<>();
	
	public void listToStr() {
		Debug.print("subListTest");
		ArrayList<Long> subList = new ArrayList<>();
		if (wifiAccessTimeList.size() > LIMIT_OF_WIFI_ACCESS_TIME) {
			subList = (ArrayList<Long>) wifiAccessTimeList.subList(wifiAccessTimeList.size() - 
					LIMIT_OF_WIFI_ACCESS_TIME, wifiAccessTimeList.size());
		}	
		wifiAccessTimeList.clear();
		wifiAccessTimeList.addAll(subList);
		Debug.print(wifiAccessTimeList.size());
	}
	
	public void strToList(){
		for(long i = 0; i < 4; i++){
			wifiAccessTimeList.add(i);
		}	
	}

}
