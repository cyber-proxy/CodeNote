package thread;

import java.util.concurrent.TimeUnit;

import SelfUtil.Debug;

public class StopThread2 {
	private static boolean stopRequested;
	
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	
	private static synchronized boolean stopRequest() {
		return stopRequested;
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread backgroundThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while (!stopRequested) {
						i++;
						Debug.print(i);
				}
			}
		});
		
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(5);
		requestStop();
	}
}
