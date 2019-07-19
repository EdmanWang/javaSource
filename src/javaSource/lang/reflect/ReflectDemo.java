package javaSource.lang.reflect;

import javaSource.lang.reflect.util.CustomerClass;
import org.junit.Test;

import java.lang.reflect.Field;

// 反射测试demo
public class ReflectDemo {

    @Test // 测试 isAccessible 函数
    public void testIsAccessibleField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        CustomerClass customerClassClass = CustomerClass.class.newInstance();

        Field privateField = CustomerClass.class.getDeclaredField("privateField");
        Field annotationField = CustomerClass.class.getDeclaredField("annotationField");

        System.out.println(privateField.get("wgx"));
        boolean flag1 = privateField.isAccessible();
        System.out.println(flag1);
        boolean flag = annotationField.isAccessible();
        System.out.println(flag);

    }

}
