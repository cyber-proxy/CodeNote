package learning.book.effictivejava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.omg.CORBA.PUBLIC_MEMBER;

import SelfUtil.Debug;

public class MainClass {
	
	private static ArrayList<String> list1 = new ArrayList<>();
	
	public static void main(String[] arg) {
		ArrayList<String> asdf = null;
		for(String string : getList()){
			Debug.print(string);
		}
		
	}
	
	private static List<String> getList(){
		Debug.print("getList called.");
		ArrayList<String> arrayList = new ArrayList<>();
		for(int i = 0; i < 100; i++){
			arrayList.add(i+"");
		}
		return arrayList;
	}
	
	private static Boolean strFunc(String a, String b){
		Debug.print("a = "+a.hashCode());
		Debug.print("b = "+b.hashCode());
		return false;
	}
	
	private static void testTryCatch() {
		Debug.print("asdf");
		List<String> lStrings = null;
		try {
			for(String string : lStrings){
				Debug.print(string);
			}
			lStrings.size();
			lStrings = new ArrayList<>();
			lStrings.clear();
			lStrings.isEmpty();
			lStrings.size();
		} catch (Exception e) {
			if (null != e) {
				Debug.print("error :"+e.toString());
				Debug.print("end");
			}
		}
		Debug.print("end");
	}
	
	private static ArrayList<String> getStrList() {
		list1.add("aaaaaaaaaaaaaa");
		
		List<String> temp;
		temp = list1;
		temp.add("temp");
		Debug.print(temp.toString());
		
		return (ArrayList<String>) list1.clone();
		
	}
	
	//´úÂë¶Î2
	public static <T> List<List<T>> sliceList(final List<T> list, int batchSize) {
		List<List<T>> result = new ArrayList<List<T>>();
		if (list.isEmpty() || 0 >= batchSize) {
			return result;
		}

		final int n = (list.size() + batchSize - 1) / batchSize;
		for (int i = 0; i < n; i++) {
			result.add(list.subList(i * batchSize, Math.min((1 + i) * batchSize, list.size())));//ÕâÀï
		}

		return result;
	}

}
