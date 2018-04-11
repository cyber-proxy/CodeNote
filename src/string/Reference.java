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
		// 告诉垃圾收集器打算进行垃圾收集，而垃圾收集器进不进行收集是不确定的
		System.gc();
		// 强制调用已经失去引用的对象的finalize方法
		System.runFinalization();
		Debug.print(weakHashMap.size());
	}
}
