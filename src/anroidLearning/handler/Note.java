package anroidLearning.handler;

/**
 *  1��	�����߳��п�����һ��while(1)ѭ����ѭ���mq�����л�ȡmessage��ִ��message�е�runnable������UI��ص����в������������߳̽��С�
	2��	handler��κ����߳���ء�Message������Handler��HandlerΪ�Զ������Ϣ��������Handler�����߳�Looper�кι�ϵ��
	3��	Handler��������Ϊ�Զ���Message,����Message��msg.what��ֵ��ת��msg.obj�����ͣ�������ת�������͵ķ�������ôHandler.HandleMessage�������ﱻ���õ��أ�
	3.1��Message.obtain(msg).sendToTarget();���ǽ���msg����msg.target�Ķ����С�
	4��	ÿһ��Message���汣����һ��ֵtarget�������˴����Message��Handler����Message.sendToTarget��ִ��target.sendMessage(this)������Message������
	4.1��������������̶߳��л��ǵ�ǰ�̶߳��У�������о���Looper��mQueue��HandlerĬ�ϵ�Looper�ǵ�ǰ�߳�Looper.myLooper()��
	4.2��һ���߳�ֻ��һ��Looper����һ��Looper����ֻ��һ�����
	4.3��Looper�Ӷ�����ȡ��msg������msg�������汣���handler����
	5��	��Looper���������ѭ�����ڵ�ǰLooper�Ķ�������ȡ��msg�������ô�msg��target.dispatchMessage(msg)��ʵ��ִ�е���handler->dispatchMessage,���msg.callback��Ϊnull����ֱ��ִ�д�msg��callback��Ϊnull�����Handler��callback����callback��Ϊnull, 
		�����handler��andleMessage(msg)������ִ��˳����:msg.callback > handler.callback > handler.handleMessage.
	5.1�������Ҫ�ڷ����߳���������Looper��Handler����������ô���أ�
	5.2��Handler.post(ruanable)���ǽ�msg(ruannable)�������handler������ĵ�Looper�Ķ�������ȥ�������ǰ�������̣߳�������Handler.post,��ô���������߳�����ִ���˴�Runnable����
	6��	���й���msg�Ĳ��������ͣ�������Ϣ��������msg�Ķ����С������ǵ���msg��handler����msg���󣻷��͵�ʱ���ǰ�msg���͵�msg��handler��Looper�Ķ����У������ǣ��Ӷ�����ȡ��msg������msg.handler�Ĵ���������
	7��	��Dialog.java���棬public void dismiss()��ʵ��Ϊ��Ҫ�жϣ�if(Looper.getMyLooper() == mHandler.getLooper()) ��Ŀ���������κ��̶߳����Խ���dialog��ʧ�����жϵ�ǰ�̵߳�Looper�Ƿ��Ǵ�Dialog�����mHandler���е�Looper()�������ͬ����ѶԻ�����ʧ�����߼��ŵ����Ի�����еĶ�����ȥִ�С�
 */
public class Note {

}
