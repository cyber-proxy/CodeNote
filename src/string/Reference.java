package string;

import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;

import SelfUtil.Debug;

public class Reference {
	public static void main(String[] args) {
		WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
		weakHashMap.put("asdf", "asdf");
		weakHashMap.put(new String("a"), "asdf");
		weakHashMap.put(new String("f"), "asdf");
		weakHashMap.put(new String("c"), "asdf");
		weakHashMap.put(new String("c"), "asdf");
		Debug.print(weakHashMap.size());
		// ���������ռ���������������ռ����������ռ������������ռ��ǲ�ȷ����
		System.gc();
		// ǿ�Ƶ����Ѿ�ʧȥ���õĶ����finalize����
		System.runFinalization();
		Debug.print(weakHashMap.size());
	}
}
