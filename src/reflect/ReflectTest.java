package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;

import SelfUtil.Debug;

public class ReflectTest {
	public static void main(String[] args){
		
		try{
			test();
		}catch (Exception e) {
			e.printStackTrace();
		}
		 String input = "1 fish 2 fish red fish blue fish";
		 Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
		 System.out.println(s.nextInt());
		 System.out.println(s.nextInt());
		 System.out.println(s.next());
		 System.out.println(s.next());
		 
		 Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				Debug.print(".................");
				
			}
		}));
		 
		 try{
//			 throw new RuntimeException("asdf");
		 }finally {
//			return;
		}
		 
		 if (null instanceof String) {
			return;
		}
		
	}
	
	private static void test() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		Foo foo = new Foo();
		Debug.print(foo);
		
		Method method = Foo.class.getDeclaredMethod("setBar", int.class);
		method.setAccessible(true);
		method.invoke(foo, 42);
		
		Debug.print(foo);
		Field field = Foo.class.getDeclaredField("bar");
		field.setAccessible(true);
		field.set(foo, 23);
		Debug.print(foo);
	}
}
