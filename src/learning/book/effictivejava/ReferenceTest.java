package learning.book.effictivejava;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import SelfUtil.Debug;

public class ReferenceTest {
	
	public static String test() {
		String aString =new String("a");
		WeakReference<String> weakReference = new WeakReference<String>(aString);
		WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();
		weakHashMap.put(weakReference.get(), 1);
		aString = null;
		//System.gc();
		String cString = "";
		try {
			cString = weakReference.get().replace("a", "b");
			return cString;
		} catch (Exception e) {
			if (e != null) {
				Debug.print(e.toString());				
			}
			cString = "C";
			return cString;
		}finally {
			cString += "d";
			return cString + "e";
		}
	}
	
	public static void main(String[] args) {
		Debug.print(test());
	}

}
