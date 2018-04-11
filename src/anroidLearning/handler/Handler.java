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
		
		//Looperѭ���з���message�󣬵���message.targer�͵õ��˵�ǰhandler��ʹ��taget.handleMessage
		//�Ͱ���Ϣת�����˷���messageʱ��handler��handleMessage����
		msg.target=this;
		
		messageQueue.enqueueMessage(msg);
		
	}
	
	public void handleMessage(Message msg) {
    }

}
