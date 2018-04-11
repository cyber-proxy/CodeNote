package thread.concurrent;

import java.util.concurrent.CountDownLatch;

import SelfUtil.Debug;

public class CountDownLatchTest {
	private final static CountDownLatch M_COUNT_DOWN_LATCH = new CountDownLatch(2);
	
	private static class WorkingThread extends Thread{
		private final String mThreadName;
		private final int mSleepTime;
		public WorkingThread(String name, int sleepTime){
			mThreadName = name;
			mSleepTime = sleepTime;
		}
		@Override
		public void run(){
			Debug.print("["+mThreadName+"] started!");
			try {
				Thread.sleep(mSleepTime);
			} catch (Exception e) {
				// TODO: handle exception
			}
			M_COUNT_DOWN_LATCH.countDown();
			Debug.print("["+mThreadName+"] end!");
		}
	}
	
	private static class SampleThread extends Thread{
		@Override
		public void run(){
			Debug.print("[SampleThread] started!");
			try {
				M_COUNT_DOWN_LATCH.await();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Debug.print("[SampleThread] end!");
		}
	}
	
	public static void main(String[] args) throws Exception{
		new SampleThread().start();
		new WorkingThread("WorkingThread1", 5000).start();
		new WorkingThread("WorkingThread2", 2000).start();
	}
}
