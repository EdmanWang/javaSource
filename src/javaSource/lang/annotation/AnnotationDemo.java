package javaSource.lang.annotation;

import javaSource.lang.annotation.util.MyLocalVariableAnnotation;
import javaSource.lang.annotation.util.MyMethodAnnotation;

import javaSource.lang.annotation.util.MyFieldAnnotation;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 测试注解
public class AnnotationDemo {

    protected String strOne;

    // 测试自定义的字段注解
    @MyFieldAnnotation(value = "wgx")
    public String strTwo;

    @Test
    @MyMethodAnnotation(str = "wgx", val = 24)
    public void testOne(String one, int two) throws NoSuchFieldException {
        System.out.println("one is ----->" + one + "two is ----->" + two);
        // getDeclaredField 得到全部声明的字段
        Field str01 = AnnotationDemo.class.getDeclaredField("strOne");
        System.out.println(str01.getName());

        // getField 得到是public 修饰的字段
        String str = AnnotationDemo.class.getField("strTwo").getAnnotation(MyFieldAnnotation.class).value();
        System.out.println("str value is --->" + str);
    }

    // @Test junit 单元测试不是不能有参数的
    public void display(String str) {
        System.out.println(str);
    }

    @Test  //测试自定义方法注解 ，需要将testOne函数上的@Test去掉
    public void testTwo() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method testOne = AnnotationDemo.class.getDeclaredMethod("testOne", String.class, int.class);
        MyMethodAnnotation myMethodAnnotation = testOne.getAnnotation(MyMethodAnnotation.class);
        String str = myMethodAnnotation.str();
        int val = myMethodAnnotation.val();
        System.out.println("str------->" + str);
        System.out.println("val------->" + val);
        testOne.invoke(AnnotationDemo.class.newInstance(), str, val);
    }

    @Test  // 测试局部变量注解   --- 很少用
    public void testThree() {
        @MyLocalVariableAnnotation(str = "wgx") String localString;
        System.out.println();
    }
}
