package javaSource.lang.annotation.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)   //  设置注解的类型 -- 类型注解   --- 构造方法
@Retention(RetentionPolicy.RUNTIME)  // 设置注解的生命周期
public @interface MyConstructAnnotation {
    public int id() default -1;

    public String msg() default "Hi";

}
