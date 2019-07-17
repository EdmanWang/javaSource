package javaSource.lang.annotation.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义的方法注解
@Retention(RetentionPolicy.RUNTIME)  // 设置注解的保留策略 即：什么时候回丢弃
@Target(ElementType.METHOD) // 声明注解类型 -- 为方法注解，作用在方法上
public @interface MyMethodAnnotation {  // 全部的注解 都是继承java.lang.annotation.Annotation接口
    String str();

    int val();   //  注解 中的成员只能用基本数据类型修饰
}

