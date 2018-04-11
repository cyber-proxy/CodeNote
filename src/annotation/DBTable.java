package annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Retention(RetentionPolicy.SOURCE) // 编译的时候忽视
@Retention(RetentionPolicy.CLASS) // 只保留到编译的时候，不会被加载到JVM中
public @interface DBTable {

}
