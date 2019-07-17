package javaSource.lang.annotation.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义的字段注解
@Target(ElementType.TYPE)   //  设置注解的类型 -- 类型注解
@Retention(RetentionPolicy.RUNTIME)  // 设置注解的生命周期
public @interface MyClassAnnotation {
    public int id() default -1;

    public String msg() default "Hi";

}
