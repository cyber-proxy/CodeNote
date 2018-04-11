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
	 * ���Դ˺����᲻�����̰߳�ȫ���⡣
	 * ��Ҫ֤���������ǣ�ÿ�����������Լ����߳�ջ����ô�ں����ڲ����ı�ȫ�ֱ�������������������ı���������ô�˺����������̰߳�ȫ���⡣
	 * ��Ҫ�ó��Ľ��ۣ�Java�߳�ջ�ڴ�ģ����ʲô���ģ���ִ��ĳ��������ʱ�򣬱�����ʲô������	
	 * �����ص㣺
	 * 	1�����ʵ�������ķ��������Ҵ˷����Ƿ��ش˵�������ĳ�Ա���ݡ�
	 * 	2��Clone����������̰߳�ȫ������
	 * �����ɵ㣺������ͬһ�����󣬲��ҷ�����ͬһ�������ͬһ����Ա������ִ����Clone������
	 * @return
	 */
	public ArrayList<Info> getInfos(){
		return (ArrayList<Info>)infos.clone();
	}
	

}
