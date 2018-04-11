package anroidLearning.handler;

public class Handler {
	private MessageQueue messageQueue;
	
	public Handler() {

		Looper looper=Looper.myLooper();
		
		if (looper==null) {
			 throw new RuntimeException(
		                "Can't create handler inside thread that has not called Looper.prepare()");
		       
		}
		
		this.messageQueue=looper.messageQueue;
	}

	public void sendMessage(Message msg) {
		
		//Looper循环中发现message后，调用message.targer就得到了当前handler，使用taget.handleMessage
		//就把消息转发给了发送message时的handler的handleMessage函数
		msg.target=this;
		
		messageQueue.enqueueMessage(msg);
		
	}
	
	public void handleMessage(Message msg) {
    }

}
