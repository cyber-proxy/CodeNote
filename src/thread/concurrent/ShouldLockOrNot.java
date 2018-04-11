package thread.concurrent;

import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

public class ShouldLockOrNot {
	private static ShouldLockOrNot instance = null;
	
	public static ShouldLockOrNot getInstance(){
		if (instance != null) {
			return instance;
		}else{
			synchronized(ShouldLockOrNot.class){
				if (instance != null) {
					return instance;
				}else{
					instance = new ShouldLockOrNot();					
				}				
			}
		}
		return instance;
	}
	
	public static class Info{
		private String name;
		public Info(String name){
			this.name = name;
		}
	}
	private ArrayList<Info> infos = new ArrayList<Info>(){
		{
			for(int i = 0; i < 10; i++){
				add(new Info("" + i));
			}
		}
	};
	
	/**
	 * 测试此函数会不会有线程安全问题。
	 * 需要证明的问题是：每个函数都有自己的线程栈，那么在函数内部不改变全局变量（即函数作用域外的变量），那么此函数不存在线程安全问题。
	 * 需要得出的结论：Java线程栈内存模型是什么样的？在执行某个函数的时候，保存了什么东西？	
	 * 场景特点：
	 * 	1、访问单例对象的方法，并且此方法是返回此单例对象的成员内容。
	 * 	2、Clone函数会存在线程安全问题吗？
	 * 场景疑点：访问了同一个对象，并且访问了同一个对象的同一个成员，并且执行了Clone方法。
	 * @return
	 */
	public ArrayList<Info> getInfos(){
		return (ArrayList<Info>)infos.clone();
	}
	

}
