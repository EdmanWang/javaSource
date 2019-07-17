package javaSource.lang.annotation.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义的字段注解
@Retention(RetentionPolicy.RUNTIME)  // 设置注解的生命周期
@Target(ElementType.FIELD)   //  设置注解的类型 -- 字段类型 作用在字段上
public @interface MyFieldAnnotation {
    String value();
}
