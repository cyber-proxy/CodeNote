package memory;

import java.util.HashMap;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
/**
 * 测试关于哈希表操作，出现崩溃的情况。
 * 1、如果一个变量持有哈希表值集合中的值的引用（自定义类型的对象），如果在某处调用了hashtable.remove()，
 * 对此变量访问，会导致空指针异常吗？
 * @author Administrator
 *
 */
public class HashTableOperation {
	
	private static HashMap<Integer, String> stringTable = new HashMap<>();
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++){
			stringTable.put(Integer.valueOf(i), String.valueOf(i));
		}
		String aString = stringTable.get(2);	
		
		stringTable.remove(2);
		
		SelfUtil.Debug.print(aString);
	}
}
