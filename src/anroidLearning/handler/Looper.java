package anroidLearning.handler;

public class Looper {
	private static final ThreadLocal<Looper> threadLocal=new ThreadLocal<>();
/**
 * �洢Message�Ķ��У�����ʽ��û����Ϣ��һֱ�ȴ�
 */
final MessageQueue messageQueue;


private Looper() {
	messageQueue=new MessageQueue();
}

/**Ϊ���̴߳���Looper��
 * �����߳��Ѿ���Looper������Ҫ�ٴε���prepare
 */
public  static void prepare() {
	if (threadLocal.get() != null) {
        throw new RuntimeException("Only one Looper may be created per thread");
    }
	threadLocal.set(new Looper() );
}

public static void loop() {
	Looper looper=myLooper();
	if (looper == null) {
        throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
    }
	MessageQueue messageQueue=looper.messageQueue;
	
	for(;;){
		Message message=messageQueue.next();
		message.target.handleMessage(message);
	}
}

/**
 * ��ȡ�����̵߳�Looper
 * @return
 */
public static Looper myLooper() {
	return threadLocal.get();
}

}
