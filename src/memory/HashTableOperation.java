package memory;

import java.util.HashMap;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
/**
 * ���Թ��ڹ�ϣ����������ֱ����������
 * 1�����һ���������й�ϣ��ֵ�����е�ֵ�����ã��Զ������͵Ķ��󣩣������ĳ��������hashtable.remove()��
 * �Դ˱������ʣ��ᵼ�¿�ָ���쳣��
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
