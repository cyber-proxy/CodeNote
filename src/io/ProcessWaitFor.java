package io;

import SelfUtil.Debug;

public class ProcessWaitFor {
	// http://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html
	
	public static void main(String[] strings) {
		test1();
	}
	
	public static void test1(){
		try{
			System.loadLibrary("");
			Debug.print("start.");
			Process process = Runtime.getRuntime().exec("SystemInfo");
			process.waitFor();
			Debug.print("end");
			
		}catch (Exception e) {
			Debug.print(e.getMessage().toString());
		}
	}

}
