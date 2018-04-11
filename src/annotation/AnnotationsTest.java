package annotation;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;

import SelfUtil.Debug;

public class AnnotationsTest {
	public static void main(String[] args){
		Debug.print("start:");
		Set<Field> declaredColumnFields = Collections.emptySet();
	}
	
	@Table(name="asdf")
	private static class CacheTestModel2 {
		//
	}
}
