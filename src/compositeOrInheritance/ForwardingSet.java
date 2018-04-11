package compositeOrInheritance;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E> {
	
	private final Set<E> s; 
	
	public ForwardingSet(Set<E> s) {
		this.s = s;
	}

	@Override
	public boolean add(E arg0) {
		return s.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		return s.addAll(arg0);
	}

	@Override
	public void clear() {
		s.clear();		
	}

	@Override
	public boolean contains(Object arg0) {
		return s.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return s.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return s.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return s.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return s.retainAll(arg0);
	}

	@Override
	public int size() {
		return size();
	}

	@Override
	public Object[] toArray() {
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return s.toArray(arg0);
	}

}
