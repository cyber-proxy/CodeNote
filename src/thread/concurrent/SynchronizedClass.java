package thread.concurrent;

import javax.swing.DefaultBoundedRangeModel;

import SelfUtil.Debug;

public class SynchronizedClass {
	
	private static Integer integer = 0;
	
	public static void main(String[] args) {

		Thread synchronizedTest = new Thread(new Runnable() {		
			@Override
			public void run() {
				synchronized(this){
					name(this);
				}
				
			}
		});
		synchronizedTest.start();
		
		final SynchronizedClass synchronizedClass = new SynchronizedClass();
		Thread thread0 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					synchronizedClass.function();
//					staticFunction();
				} catch (Exception e) {
					// TODO: handle exception
					Debug.print(e.toString());
				}
			}
		});
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					synchronizedClass.function();
//					staticFunction();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		thread0.setName("thread0");		
		thread0.start();
		thread1.setName("thread1");
		thread1.start();
	}
	
	public static void staticFunction() throws InterruptedException {
		for (; integer < 100;) {
			integer++;
			Debug.print("Thread:"+Thread.currentThread().getName()+ " integer = "+integer);
		}
	}
	
	public  void function() throws InterruptedException {
		for (; integer < 100;) {
			synchronized (SynchronizedClass.class) {
				if (integer >= 100) {
					break;
				}
				integer++;
				Debug.print("Thread:"+Thread.currentThread().getName()+ " integer = "+integer);				
			}
		}
	}
			
	public static void name(Runnable test) {
		synchronized (test) {
			Debug.print("aaaaaaaaaaaaa");
		}
	}
}
