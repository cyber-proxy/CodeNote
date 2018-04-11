package eventbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBusTest {
	
	private static volatile EventBusTest defaultInstace;
	
	private static final Map<Class<?>, List<Class<?>>> eventTypeCache = new HashMap<Class<?>, List<Class<?>>>();
	
	private final ThreadLocal<PostingThreadState> currentPostingThreadState = new ThreadLocal<PostingThreadState>(){
		@Override
		protected PostingThreadState initialValue(){
			return new PostingThreadState();
		}
	};
	
	public static EventBusTest getDefault() {
		if (null == defaultInstace) {
			synchronized (EventBusTest.class) {
				defaultInstace = new EventBusTest();
			}
		}
		return defaultInstace;
	}
	
	public void post(Object event) {
		PostingThreadState postingThreadState = currentPostingThreadState.get();
		List<Object> eventQueue = postingThreadState.eventQueue;
		eventQueue.add(event);
		
		if (postingThreadState.isPosting) {
			return;
		}else {
//			postingThreadState.isMainThread = Looper
		}
	}
	
	private void postSingleEvent(Object event, PostingThreadState postingThreadState) throws Error{
		Class<? extends Object> eventClass = event.getClass();
	}
	
	final static class PostingThreadState{
		List<Object> eventQueue = new ArrayList<>();
		boolean isPosting;
		boolean isMainThread;
		Subscription subscription;
		Object event;
		boolean canceled;
	}

}
