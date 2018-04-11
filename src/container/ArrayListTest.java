package container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import SelfUtil.Debug;
import memory.readme;

public class ArrayListTest {

    public static final long SECOND = 1000;
    public static final long MINUTE = 60 * 1000;
    public static final long HOUR = 60 * MINUTE;
    public static final long HALF_HOUR = 30 * MINUTE;
    public static final long DAY = 24 * HOUR;
	
	public static void main(String[] args) {
//		testNUll();
//		testRemove();
//		Debug.print(getUsedTime(System.currentTimeMillis()/2));
		testSetAndList();
	}


    public static String getUsedTime(long time) {
        int hour = (int) (time / HOUR);
        int minuite = (int) ((time % HOUR) / MINUTE);
        int second = (int) ((time % MINUTE) / SECOND);
        StringBuilder sb = new StringBuilder();
        if (hour != 0) {
            sb.append(hour).append(":");
        }
        String sMinute = "00" + minuite;
        Debug.print(sb.toString());
        sb.append(sMinute.substring(sMinute.length() - 2)).append(":");
        Debug.print(sb.toString());
        String sSecond = "00" + second;
        Debug.print(sb.toString());
        sb.append(sSecond.substring(sSecond.length() - 2));
        Debug.print(sb.toString());
        return sb.toString();
    }
	
	private static void testNUll(){
        ArrayList var3 = new ArrayList();
        var3.add(null);
        var3.add(null);
        var3.add(null);
        var3.add(null);
        var3.add("asdf");
        for(Object object : var3){
        	if (object == null) {
				Debug.print("is null");
			}else {
				if (object instanceof String) {
					Debug.print("value is:"+object.toString());
				}
			}
        }
	}
	
	public static class content {
		String aString ;
		String bString;
		public content(String a, String b) {
			aString = a;
			bString = b;
		}

		public boolean equals(content c){
			return c.aString.equals(aString);
		}

		public boolean equals(String c){
			return c.equals(aString);
		}
		
		@Override		
		public String toString() {
			return "aString = " + aString + " bString = " + bString;
		}
	}
	
	private static void testRemove() {
        ArrayList<content> var3 = new ArrayList();
        var3.add(new content("123", "asd"));
        var3.add(new content("123", "asd"));
        var3.add(new content("123", "asd"));
        var3.add(new content("23", "qwe"));
		for(content ctent : var3){
			if (ctent.equals("123")) {
				Debug.print("123 's hashcode = " + ctent.hashCode());
				var3.remove(ctent);
			}
		}
		Iterator<content> iterator = var3.iterator();
		while (iterator.hasNext()) {
			content aString = iterator.next();
			if (aString.equals("123")) {
				iterator.remove();
			}else {
				aString.aString = "asdf";
			}
			
		}
		for(content aString : var3){
			Debug.print(aString);
		}
	}
	
	private static void testSetAndList(){
		Set<String> temp = new HashSet<>();
		temp.add("asdf");
		temp.add("asdf");
		temp.add("asdf");
		temp.add("asdf");
		
		List<String> list = new ArrayList<>();
		list = Arrays.asList(temp.toArray(new String[]{}));
		list.clear();
	}
	
}
