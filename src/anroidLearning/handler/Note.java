package anroidLearning.handler;

/**
 *  1、	在主线程中开启了一个while(1)循环，循序从mq队列中获取message，执行message中的runnable方法。UI相关的所有操作必须在主线程进行。
	2、	handler如何和主线程相关。Message保存了Handler，Handler为自定义的消息处理函数。Handler和主线程Looper有何关系。
	3、	Handler的作用是为自定义Message,根据Message的msg.what的值，转换msg.obj的类型，并调用转换后类型的方法。那么Handler.HandleMessage是在哪里被调用的呢？
	3.1、Message.obtain(msg).sendToTarget();就是将此msg加入msg.target的队里中。
	4、	每一个Message里面保存了一个值target，保存了处理该Message的Handler对象，Message.sendToTarget会执行target.sendMessage(this)，将此Message放入队里。
	4.1、这个队里是主线程队列还是当前线程队列？这个队列就是Looper的mQueue，Handler默认的Looper是当前线程Looper.myLooper()。
	4.2、一个线程只有一个Looper对象，一个Looper对象只有一个队里。
	4.3、Looper从队列中取出msg，交给msg对象里面保存的handler处理。
	5、	在Looper里面的无限循环会在当前Looper的队列里面取出msg，并调用此msg的target.dispatchMessage(msg)，实际执行的是handler->dispatchMessage,如果msg.callback不为null，则直接执行此msg的callback，为null则调用Handler的callback，此callback再为null, 
		则调用handler的andleMessage(msg)，所以执行顺序是:msg.callback > handler.callback > handler.handleMessage.
	5.1、如果需要在非主线程里面利用Looper和Handler技术，该怎么办呢？
	5.2、Handler.post(ruanable)就是将msg(ruannable)对象放入handler相关联的的Looper的队列里面去。如果当前是在主线程，调用了Handler.post,那么就是在主线程里面执行了此Runnable方法
	6、	所有关于msg的产生，发送，处理信息都保存在msg的对象中。产生是调用msg的handler产生msg对象；发送的时候，是把msg发送到msg的handler的Looper的队里中；处理是，从队里中取出msg，调用msg.handler的处理函数处理。
	7、	在Dialog.java里面，public void dismiss()的实现为何要判断：if(Looper.getMyLooper() == mHandler.getLooper()) 此目的在于在任何线程都可以将此dialog消失掉，判断当前线程的Looper是否是此Dialog对象的mHandler持有的Looper()，如果不同，则把对话框消失处理逻辑放到，对话框持有的队列上去执行。
 */
public class Note {

}
