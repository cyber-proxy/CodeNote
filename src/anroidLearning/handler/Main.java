package anroidLearning.handler;

/**
 * ��ģ��������ѧϰLooper, Handler�� Message����ֱ�ӵĹ�ϵ�������ô�����ȫģ��Android���첽����ϵͳ��
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
		
		//��ѭ��������ʽ
		Looper.loop();
		
		//���� �Ĵ���ͨ������ִ��
		System.out.println("exit........");
		throw new RuntimeException("Main thread loop unexpectedly exited");
	
	}
	
	private void onCreate() {
		//////////////////////////////////////////////////////////
		////// ����Ĳ����൱��������android��UI�߳��� ////////////
		//////////////////////////////////////////////////////////
	
		final Thread thread = Thread.currentThread();
		System.out.println("main thread=" + thread);
	
		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				//��thread == Thread.currentThread()����֤���Ѿ����������߳�����
				System.out.println("current thread is main thread? " + (thread == Thread.currentThread()));
				System.out.println(msg);
				System.out.println();
			}
		};
		// ����1       ���̴߳���handler�����߳�ʹ�ø�handler������Ϣ 
		new Thread() {
			public void run() {
				try {//ģ���ʱ����
					Thread.sleep(1000 * 2);
				} catch (InterruptedException e) {
				}
				Message message = Message.obtain();
				message.obj = "new Thread" + Thread.currentThread();
				message.what = (int) System.currentTimeMillis();
				//�����߳��з�����Ϣ 
				handler.sendMessage(message);
				
				try {
					Thread.sleep(1000 * 2);
				} catch (InterruptedException e) {
				}
				
				message = new Message();
				message.obj = "hanler...waht==1" ;
				message.what = 1;
				//�����߳��з�����Ϣ 
				handler.sendMessage(message);
				
	
				message = new Message();
				message.obj = "hanler...waht==2" ;
				message.what = 2;
				//�����߳��з�����Ϣ 
				handler.sendMessage(message);
				
				message = new Message();
				message.obj = "hanler...waht==3" ;
				message.what = 3;
				//�����߳��з�����Ϣ 
				handler.sendMessage(message);
				
			};
		}.start();
	
		// ����2 ��thread�ڲ�����handler��������׳��쳣
		new Thread() {
			public void run() {
				try {
					sleep(1000 * 3);
				} catch (InterruptedException e) {
				}
				/*
				 * ���߳��ڲ�ʹ��Ĭ�Ϲ��캯������handler���׳��쳣��
				 * android��Ҳ���������߳��д���Handler����Ҫ�ڳ�ʼ��ʱ����Looper��
				 * Looper.getMainLooper()��ȡ���ľ������̵߳�Looper�����Կ�����������
				 * 
				 * new Handler(Looper.getMainLooper()){
						@Override
						public void handleMessage(Message msg) {
							//���������߳���
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
				//�����߳��з�����Ϣ 
				h.sendMessage(message);
	
			};
		}.start();
	
		//////////////////////////////////////////////////////////
		////// ����Ĳ����൱��������android��UI�߳��� ////////////
		//////////////////////////////////////////////////////////
	
	}

}
