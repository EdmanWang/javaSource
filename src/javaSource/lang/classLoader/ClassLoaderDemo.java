package javaSource.lang.classLoader;

import javaSource.lang.classLoader.util.CustomerClassLoader;
import javaSource.lang.classLoader.util.PersonFour;
import javaSource.lang.classLoader.util.PersonOne;
import javaSource.lang.classLoader.util.PersonThree;
import javaSource.lang.classLoader.util.PersonTwo;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

// 测试classLoader 类加载器的相关

/**
 * 对于普通的开发者来说，classLoader 用到的地方不多，但是对于框架的开发者来说就需要理解其中的加载机制。
 * classLoader 的作用
 * 1：就是将class文件加载到jvm中去。
 * 2：但是在jvm启动的时候，并不会一次就加载全部的class文件，而是动态的加载class文件
 * <p>
 * 什么时候回触发jvm去调用类加载器去加载类
 * 1：new 关键字
 * 2：反射
 * java 语言自带三个类加载器
 */

/**
 * java 类 加载过程
 * 1：程序员写好的以 .java结尾的java源文件，通过java特定的java编译器，编译成以.class结尾的二进制文件
 * 2; 当程序员启动java 虚拟机，虚拟机会调用Launcher 去加载特定的文件夹下的jar文件。当遇到的是
 * 3： 程序运行的时候，遇到一些触发条件会加载指定的类（自己编写的类）
 */
public class ClassLoaderDemo {

    @Test
    public void testSecurityManager(){

        String property = System.getProperty("java.security.manager");
        System.out.println(property);
    }

    @Test // 测试扩展 BootstrapClassLoader 类加载器 ，最顶端的类加载器
    public void testBootstrapClassLoader() {   //  加载一些核心jar 文件 比如（resources.jar，rt.jar）
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("-------------------------------");
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test // 测试扩展 ExtentionClassLoader 类加载器
    public void testExtentionClassLoader() {   // D:\WorkSoft\jdk1.8.0_92-64\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext
        System.out.println(System.getProperty("java.ext.dirs"));
        StringTokenizer var2 = new StringTokenizer(System.getProperty("java.ext.dirs"), File.pathSeparator);
        int i = var2.countTokens();
        System.out.println(var2.nextToken());
        System.out.println(i);
        System.out.println(var2);
        System.out.println(System.nanoTime());  // 显示系统纳秒时间
    }

    @Test // 测试 AppClassLoader 类加载器
    public void testAppClassLoader() {
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test // 测试 loadClass 函数
    public void testLoadClass() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader("D:\\");
        Class<?> personClass = customerClassLoader.loadClass("One");

        InputStream resourceAsStream = customerClassLoader.getResourceAsStream("src/javaSource/lang/classLoader/util/wgx01.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/javaSource/lang/classLoader/util/wgx.txt"));
        int read;
        while ((read = resourceAsStream.read()) != -1) {
            fileOutputStream.write(read);
        }
        fileOutputStream.close();
        resourceAsStream.close();

        System.out.println("写入完毕");
        ClassLoader classLoader = personClass.getClassLoader();
        System.out.println(classLoader);
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
