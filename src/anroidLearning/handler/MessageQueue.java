package anroidLearning.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
	
	private BlockingQueue<Message>blockingQueue=new LinkedBlockingQueue<>();

/**
 * 阻塞式，没有消息则一直等待
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
 * 插入到消息队列尾部
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
