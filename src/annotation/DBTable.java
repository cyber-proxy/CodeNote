package annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Retention(RetentionPolicy.SOURCE) // �����ʱ�����
@Retention(RetentionPolicy.CLASS) // ֻ�����������ʱ�򣬲��ᱻ���ص�JVM��
public @interface DBTable {

}
