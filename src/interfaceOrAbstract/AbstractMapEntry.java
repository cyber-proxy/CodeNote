package interfaceOrAbstract;

import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractMapEntry<K, V> implements Entry<K, V> {
	public abstract K getKey();
	public abstract V getValue();
	
	public V setValue(V value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object o){
		if (o == this) {
			return true;
		}
		if (!(o instanceof Map.Entry)) {
			return false;
		}
		Map.Entry<?, ?> arg = (Map.Entry)o;
		return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());		
	}
	private boolean equals(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}
	
	
}
