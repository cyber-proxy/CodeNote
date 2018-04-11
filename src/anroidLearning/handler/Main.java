package anroidLearning.handler;

/**
 * 此模块作用是学习Looper, Handler， Message三者直接的关系，并且用代码完全模拟Android的异步处理系统。
 * @author LiCheng
 *
 */
public class Main {
	
	public static void main(String[] args) {

	new Main().start();
	
	}
	
	private void start(){
		
		Looper.prepare();
	
		onCreate();
		
		//死循环，阻塞式
		Looper.loop();
		
		//下面 的代码通常不会执行
		System.out.println("exit........");
		throw new RuntimeException("Main thread loop unexpectedly exited");
	
	}
	
	private void onCreate() {
		//////////////////////////////////////////////////////////
		////// 下面的操作相当于运行在android的UI线程中 ////////////
		//////////////////////////////////////////////////////////
	
		final Thread thread = Thread.currentThread();
		System.out.println("main thread=" + thread);
	
		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				//若thread == Thread.currentThread()，则证明已经运行在主线程中了
				System.out.println("current thread is main thread? " + (thread == Thread.currentThread()));
				System.out.println(msg);
				System.out.println();
			}
		};
		// 测试1       主线程创建handler，子线程使用该handler发送消息 
		new Thread() {
			public void run() {
				try {//模拟耗时操作
					Thread.sleep(1000 * 2);
				} catch (InterruptedException e) {
				}
				Message message = Message.obtain();
				message.obj = "new Thread" + Thread.currentThread();
				message.what = (int) System.currentTimeMillis();
				//在子线程中发送消息 
				handler.sendMessage(message);
				
				try {
					Thread.sleep(1000 * 2);
				} catch (InterruptedException e) {
				}
				
				message = new Message();
				message.obj = "hanler...waht==1" ;
				message.what = 1;
				//在子线程中发送消息 
				handler.sendMessage(message);
				
	
				message = new Message();
				message.obj = "hanler...waht==2" ;
				message.what = 2;
				//在子线程中发送消息 
				handler.sendMessage(message);
				
				message = new Message();
				message.obj = "hanler...waht==3" ;
				message.what = 3;
				//在子线程中发送消息 
				handler.sendMessage(message);
				
			};
		}.start();
	
		// 测试2 在thread内部创建handler，结果会抛出异常
		new Thread() {
			public void run() {
				try {
					sleep(1000 * 3);
				} catch (InterruptedException e) {
				}
				/*
				 * 在线程内部使用默认构造函数创建handler会抛出异常。
				 * android中也可以在子线程中创建Handler，但要在初始化时传入Looper，
				 * Looper.getMainLooper()获取到的就是主线程的Looper，所以可以这样创建
				 * 
				 * new Handler(Looper.getMainLooper()){
						@Override
						public void handleMessage(Message msg) {
							//运行在主线程中
						}
					};
				 */
				Handler h = new Handler() {
					public void handleMessage(Message msg) {
	
						System.out.println("haneler msg...." + msg);
					};
				};
	
				Message message = new Message();
				message.obj = "handler in new Thread";
				message.what = (int) System.currentTimeMillis();
				//在子线程中发送消息 
				h.sendMessage(message);
	
			};
		}.start();
	
		//////////////////////////////////////////////////////////
		////// 上面的操作相当于运行在android的UI线程中 ////////////
		//////////////////////////////////////////////////////////
	
	}

}
