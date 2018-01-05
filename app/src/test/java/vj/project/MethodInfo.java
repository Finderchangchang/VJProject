package vj.project;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/1/5.
 */

@Target(ElementType.METHOD)
public @interface MethodInfo {
    String author() default "Pankaj";
}