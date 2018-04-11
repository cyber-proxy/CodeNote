package thread.concurrent;

import SelfUtil.Debug;

public class main {	
	public static void main(String[] args){
		Debug.print("thread concurrnt test start.");
	}
	
	Runnable CeshiCloneThreadSecurity = new Runnable() {
		
		@Override
		public void run() {
			ShouldLockOrNot.getInstance().getInfos();			
		}
	};
}  
