package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	
	public enum ConflictAction{
		ROLLBACK, ABORT, FAIL, IGNORE, REPLACE
	}
	
	public enum ForeignKeyAction{
		SET_NULL, SET_DEFAULT, CASCAE, RESTRICT, NO_ACTION
	}

}
