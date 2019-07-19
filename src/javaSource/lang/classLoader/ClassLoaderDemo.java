package javaSource.lang.classLoader;

import javaSource.lang.classLoader.util.CustomerClassLoader;
import javaSource.lang.classLoader.util.PersonFour;
import javaSource.lang.classLoader.util.PersonOne;
import javaSource.lang.classLoader.util.PersonThree;
import javaSource.lang.classLoader.util.PersonTwo;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 测试classLoader 类加载器的相关
public class ClassLoaderDemo {

    @Test // 测试扩展 BootstrapClassLoader 类加载器 ，最顶端的类加载器
    public void testBootstrapClassLoader(){   //  加载一些核心jar 文件 比如（resources.jar，rt.jar）
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("-------------------------------");
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test // 测试扩展 ExtentionClassLoader 类加载器
    public void testExtentionClassLoader(){   // D:\WorkSoft\jdk1.8.0_92-64\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.nanoTime());  // 显示系统纳秒时间
    }

    @Test // 测试 AppClassLoader 类加载器
    public void testAppClassLoader(){
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test // 测试 loadClass 函数
    public void testLoadClass() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader("D:\\");
        Class<?> personClass = customerClassLoader.loadClass("One");
        Method display = personClass.getDeclaredMethod("display", null);
        display.invoke(personClass.newInstance(), null);
    }

    @Test // 测试 Parent 字段
    public void testFindLoadedClass() {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader("D:\\");
        ClassLoader parent = customerClassLoader.getParent(); // 自定义的类加载器的parent是appClassLoader
        System.out.println("wgx------parent" + parent);
    }

    @Test   // 1:类加载时机，new一个对象的时候
    public void testClassLoadTimeOne() {

        // 虚拟机启动时候会将每一个类编译好的class文件，加载到内存中。等待虚拟机中的类加载器调用

        System.out.println("person类--调用类加载器前");
        PersonOne person = new PersonOne();
        System.out.println("person类--调用类加载器后");
    }

    @Test //  2:类加载时机，访问某个类或接口的静态变量，或者对该静态变量赋值
    public void testClassLoadTimeTwo() {

        // 虚拟机启动时候会将每一个类编译好的class文件，加载到内存中。等待虚拟机中的类加载器调用

        System.out.println("person类--调用类加载器前");
        PersonTwo.name = "qaz";    // 此处进行类类的加载
        System.out.println("类加载时机------>" + PersonTwo.name);  // 访问的时候，先查看有没有加载。
        System.out.println("person类--调用类加载器后");

    }

    @Test //  3:类加载时机，调用类的静态方法
    public void testClassLoadTimeThree() {

        // 虚拟机启动时候会将每一个类编译好的class文件，加载到内存中。等待虚拟机中的类加载器调用

        System.out.println("person类--调用类加载器前");
        PersonThree.display();
        System.out.println("person类--调用类加载器后");

    }

    @Test //  4:类加载时机，反射（Class.forName("javaSource.lang.classLoader.util.PersonOne")）
    public void testClassLoadTimeFour() throws ClassNotFoundException {

        // 虚拟机启动时候会将每一个类编译好的class文件，加载到内存中。等待虚拟机中的类加载器调用

        System.out.println("person类--调用类加载器前");
        Class<?> aClass = Class.forName("javaSource.lang.classLoader.util.PersonOne");
        System.out.println("person类--调用类加载器后");

    }

    @Test //  5:类加载时机，初始化一个类的子类（会首先初始化子类的父类）
    public void testClassLoadTimeFive() throws ClassNotFoundException {

        // 虚拟机启动时候会将每一个类编译好的class文件，加载到内存中。等待虚拟机中的类加载器调用

        System.out.println("person类--调用类加载器前");
        PersonFour personFour = new PersonFour(); // 加载子类前会先加载父类
        System.out.println("person类--调用类加载器后");

    }

    @Test //  6:类加载时机，JVM启动时标明的启动类，即文件名和类名相同的那个类
    public void testClassLoadTimeSix() throws ClassNotFoundException {

        // 虚拟机启动时候会将每一个类编译好的class文件，加载到内存中。等待虚拟机中的类加载器调用

    }

    @Test
    public void testSubstring() {
        String name = "wgx.user.Test";
        int index = name.lastIndexOf('.');
        System.out.println("index===" + index);
        if (index == -1) {
            System.out.println("wgx-------1---" + name + ".class");
        } else {
            System.out.println("wgx--------2--" + name.substring(index + 1) + ".class");
        }
    }
}
