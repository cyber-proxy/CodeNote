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
 * 1、在Java中，非静态匿名类隐式地持有外部类的引用，如果保留这个引用，会导致不被GC回收。
 * 2、在Android中处理Activity生命周期与长时间运行的任务的关系可能很困难并且可能导致内存泄露。下面有一些值得考虑的通用建议：
 * 	1）优先使用静态内部类，而不是非静态内部类。
 * 	2）不要假定Java最后总会为你清理运行中的线程.
 * 	3)Android Framework提供了很多旨在为开发者简化后台线程开发的类。
 * 		比如，考虑使用Loader而不是线程当你需要配合Activity生命周期做一些短时间的异步后台任务查询类任务。
 * 		考虑使用使用Service，然后向使用BrocastReceiver向UI反馈进度、结果。
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
