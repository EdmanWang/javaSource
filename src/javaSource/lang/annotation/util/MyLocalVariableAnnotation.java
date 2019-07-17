package javaSource.lang.annotation.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义局部变量注解
@Retention(RetentionPolicy.RUNTIME)  // 设置注解的生命周期
@Target(ElementType.LOCAL_VARIABLE)   //  设置注解的类型 -- 局部变量类型注解
public @interface MyLocalVariableAnnotation {
    String str();
}
