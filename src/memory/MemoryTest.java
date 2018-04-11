package memory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;

import SelfUtil.Debug;
import jdk.internal.dynalink.beans.StaticClass;


/**
 * 1����Java�У��Ǿ�̬��������ʽ�س����ⲿ������ã��������������ã��ᵼ�²���GC���ա�
 * 2����Android�д���Activity���������볤ʱ�����е�����Ĺ�ϵ���ܺ����Ѳ��ҿ��ܵ����ڴ�й¶��������һЩֵ�ÿ��ǵ�ͨ�ý��飺
 * 	1������ʹ�þ�̬�ڲ��࣬�����ǷǾ�̬�ڲ��ࡣ
 * 	2����Ҫ�ٶ�Java����ܻ�Ϊ�����������е��߳�.
 * 	3)Android Framework�ṩ�˺ܶ�ּ��Ϊ�����߼򻯺�̨�߳̿������ࡣ
 * 		���磬����ʹ��Loader�������̵߳�����Ҫ���Activity����������һЩ��ʱ����첽��̨�����ѯ������
 * 		����ʹ��ʹ��Service��Ȼ����ʹ��BrocastReceiver��UI�������ȡ������
 * @author Administrator
 *
 */
public class MemoryTest {
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i = 1;;i++){
					long space = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
					space = space / 1024 / 1024;
					Debug.print("occupy : "+space);		
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
					if (i > 100) {
						System.gc();
					}
				}
			}
		});
		thread.start();	
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> testList = produceAndGet();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.gc();
		testList.size();
		System.gc();
		Debug.print("main exit.....................");
	}
	
	
	
	public static List<String> produceAndGet() {
		List<String> strings = new ArrayList<>();
		for(int i = 0; i < 1000000; i++){
			strings.add("asdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		return strings;
	}
	
	

}
