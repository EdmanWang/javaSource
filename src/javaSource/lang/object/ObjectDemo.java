package javaSource.lang.object;

import javaSource.lang.classLoader.util.CustomerClassLoader;
import javaSource.lang.object.util.ObjectWaitAndNotify;
import javaSource.lang.object.util.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectDemo implements Cloneable {

    @Test  // 测试getClass 方法
    public void testGetClassMethod() throws ClassNotFoundException {
        Person person = new Person();
        // 得到一个class对象,通过字节码文件，得到一个class对象
        Class<? extends Person> personClass = person.getClass();

        ClassLoader classLoader1 = person.getClass().getClassLoader();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = Class.forName("javaSource.lang.object.util.Person").getClassLoader();
        System.out.println(classLoader2);

        // 通过的到的class对象，做相关操作。

        ClassLoader classLoader = personClass.getClassLoader(); // 默认加载的[类加载器]classLoader 是appClassLoader
        System.out.println("ClassLoader ----->" + classLoader);

        // 得到person类声明的全部字段
        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.println("field---->" + field);
        }

        // 得到person类的全部都构造函数
        Constructor<?>[] personClassConstructors = personClass.getConstructors();
        for (Constructor constructor : personClassConstructors) {
            System.out.println("constructor---->" + constructor);
        }

        // 得到person类全部的方法
        Method[] personClassMethods = personClass.getMethods();
        for (Method method : personClassMethods) {
            System.out.println("method---->" + method);
        }
    }

    @Test  // 测试 hashCode 方法
    public void testHashCodeMethod() {
        /**
         * 同一个对象的hashcode 相同 [对象指的是使用类创建出来的实例]
         * 不同对象的的hashcode 肯定是不相同的
         */
        Person person0 = new Person();
        System.out.println("test----" + person0.hashCode());
        Person person1 = new Person();
        System.out.println("test----" + person1.hashCode());
    }

    @Test // 测试 equals 方法
    public void testEqualsMethod() {
        Person person1 = new Person("1", "wgx");
        Person person2 = new Person("1", "wgx");
        // 当没有重写 equals 的时候，结果是false
        // 当有重写 equals 的时候，结果是true, 因为没有重写的时候，比较的是对象的hashCode
        System.out.println("person1 isEquals person2...." + person1.equals(person2));
    }

    @Test // 测试 clone 方法 首先需要实现Cloneable 接口
    public void testCloneMethod() throws CloneNotSupportedException {
        ObjectDemo objectDemo = new ObjectDemo();
        ObjectDemo clone = (ObjectDemo) objectDemo.clone();
        if (clone != objectDemo) { // clone 出来的对象是不同的两个对象
            System.out.println("test---clone-" + clone);
            System.out.println("true");
        }
        if (clone.getClass() == objectDemo.getClass()) { // clone出来的对象的class对象是相等的
            System.out.println("test----" + clone.getClass());
            System.out.println("true");
        }

        if (!clone.equals(objectDemo)) {  // 注意：clone 出来的对象并不是和源对象相等，是不同的对象
            System.out.println("test----" + clone);
            System.out.println("false");
        }

    }

    //    @Test // 测试 wait notify notifyAll 方法
    public static void testWaitAndBNotifyAll() {
        ObjectWaitAndNotify objectWaitAndNotify = new ObjectWaitAndNotify();

        Thread threadOne = new Thread(() -> {
            try {
                objectWaitAndNotify.product();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "one");

        Thread threadTwo = new Thread(() -> {
            try {
                objectWaitAndNotify.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "two");

        Thread threadThree = new Thread(() -> {
            try {
                objectWaitAndNotify.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "three");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

    public static void main(String[] args) {
        testWaitAndBNotifyAll();
    }
}

