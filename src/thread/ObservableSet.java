package thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import SelfUtil.Debug;
import compositeOrInheritance.ForwardingSet;

public class ObservableSet<E> extends ForwardingSet<E> {
	
	public static void main(String[] args){
		Debug.print("ObservableSet started.");
		
		ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<>());
		
		set.addObserver(new SetObserver<Integer>() {
			
			@Override
			public void added(ObservableSet<Integer> set, Integer e) {
				// TODO Auto-generated method stub
				Debug.print(e);
			}
		});
		
		for(Integer i = 0; i < 100; i++){
			set.add(i);
		}
	}

	public ObservableSet(Set<E> s) {
		super(s);
	}
	
	public void addObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}
	
	public boolean removeObserver(SetObserver<E> observer) {
		synchronized (observers) {
			return observers.remove(observer);
		}
	}
	
	private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();
	
	public interface SetObserver<E>{
		void added(ObservableSet<E> set, E element);
	}

}
