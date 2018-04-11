package io;

import java.util.HashMap;
import java.util.Map;

import SelfUtil.Debug;

public class SharedPreferencesTest {
	
	private SharedPreferencesTest() {
		mMap = new HashMap<>();
	}
	
	private Map<String, Object> mMap;
	
	public String getString(String key, String defValue) {
		synchronized (this) {
			String vString = "default";
//			try{
				vString = (String)mMap.get(key);
//			}catch (Exception e) {
//				Debug.print(e.toString());
//			}
			return vString != null ? vString : defValue;
		}
	}
	
	public Integer getInteger(String key, Integer defValue) {
		synchronized (this) {
			Integer aInteger = -1;
			aInteger = (Integer)mMap.get(key);
			return aInteger != null ? aInteger : defValue;
		}
	}
	
	public SharedPreferencesTest putInt(String key, int value){
		synchronized (this) {
			mMap.put(key, value);
			return this;
		}
	}
	
	public static void main(String[] arg){
		SharedPreferencesTest sharedPreferencesTest = new SharedPreferencesTest();
		sharedPreferencesTest.putInt("asdf", 12);
		try{
			Debug.print(sharedPreferencesTest.getString("asdf", "aaa"));
		}catch (Exception e) {
			// TODO: handle exception
			Debug.print("Error encountered");
		}
		Integer abc = 123;
		sharedPreferencesTest.putInt("asdf", abc);
		abc = 111;
		Debug.print(sharedPreferencesTest.getInteger("asdf", 1111111111));
	}

}
