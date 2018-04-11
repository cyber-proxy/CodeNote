package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import SelfUtil.Debug;


/**
 * 涉及的知识:
 * 	1.immutable
 * 	2.volatile
 * 	3.synchronized
 * 	4.AutoicLong
 * @author Administrator
 *
 */

public class StopThread {
	public static boolean stopRequested;
	
	private static final AtomicLong nextSerialNum = new AtomicLong();
	
	public static void main(String[] args) throws InterruptedException{
		Thread backgroundThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while(!stopRequested){
						i++;
						Debug.print(i);
				}
			}
		});
		
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(5);
		stopRequested = true;
	}
	
	public static long generateSerialNumber() {
		return nextSerialNum.getAndIncrement();
	}
}
