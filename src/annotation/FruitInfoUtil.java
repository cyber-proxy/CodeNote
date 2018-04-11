package annotation;

import java.io.File;
import java.lang.reflect.Field;

import javax.activation.FileDataSource;

public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz){
		String strFruitName = "";
		
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields){
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = (FruitName)field.getAnnotation(FruitName.class);
				fruitName.value();
			}
		}
	}

}
