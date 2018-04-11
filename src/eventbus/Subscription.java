package eventbus;

public class Subscription {
	final Object subscriber;
	final SubscriberMethod subscriberMethod;
	final int priority;
	
	volatile boolean active;
	
	public Subscription(Object subscriber, SubscriberMethod subscriberMethod, int priority) {
		this.subscriber = subscriber;
		this.subscriberMethod = subscriberMethod;
		this.priority = priority;
	}
}
