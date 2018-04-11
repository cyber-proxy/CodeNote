package thread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import SelfUtil.Debug;

public class SynchronizedVariable {
	
	private static Integer id = 0;
	private static Integer i = 0;	
	private static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String args[]) {
		Job job0 = new Job();
		Job job1 = new Job();
		Job job2 = new Job();
		new Thread(job0, "thread 0").start();
		new Thread(job1, "thread 1").start();
		new Thread(job2, "thread 2").start();
	}
	
	private static class Job implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (; i < 100; ) {
				synchronized (list) {
					name();
				}
			}
		}
		
	}
	
	private static void name() {
		if (i < 100) {
			i++;
			list = new ArrayList<>();
			list.add(i.toString()+",");
			Debug.print(Thread.currentThread().getName()+" list = "+list.toString());
			
		}		
	}
	

}
