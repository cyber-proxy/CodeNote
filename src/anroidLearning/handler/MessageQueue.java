package anroidLearning.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
	
	private BlockingQueue<Message>blockingQueue=new LinkedBlockingQueue<>();

/**
 * ����ʽ��û����Ϣ��һֱ�ȴ�
 * @return
 */
public Message next() {
	try {
		return blockingQueue.take();
	} catch (InterruptedException e) {
		throw new RuntimeException();
	}
}

/**
 * ���뵽��Ϣ����β��
 * @param message
 */
void enqueueMessage(Message message) {
	try {
		blockingQueue.put(message);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
