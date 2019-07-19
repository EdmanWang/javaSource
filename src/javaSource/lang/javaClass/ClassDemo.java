package javaSource.lang.javaClass;

import javaSource.lang.annotation.util.MyClassAnnotation;
import javaSource.lang.annotation.util.MyConstructAnnotation;
import javaSource.lang.javaClass.util.Person;
import javaSource.lang.javaClass.util.Son;
import javaSource.lang.javaClass.util.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// java.lang.class 源码中 class类分析
public class ClassDemo {

    // class 类中有一个私有地构造函数，是给jvm使用。

    @Test // 测试 toString 函数
    public void testToString() {
        System.out.println(int.class.toString()); // 基本数据类型  ---int
        System.out.println(User.class.toString()); // 接口  ---interface javaSource.lang.javaClass.util.User
        System.out.println(Person.class.toString()); // 类  ---class javaSource.lang.javaClass.util.Person
    }

    @Test // 测试 toGenericString 函数
    public void testToGenericString() { // 得到修饰
        System.out.println(int.class.toGenericString()); // 基本数据类型  ---int
        System.out.println(User.class.toGenericString()); // 接口  ---public abstract interface javaSource.lang.javaClass.util.User
        System.out.println(Person.class.toGenericString()); // 类  ---public class javaSource.lang.javaClass.util.Person
    }

    @Test // 测试 forName 函数
    public void testForName() throws ClassNotFoundException {
        Class<?> forName = Class.forName("javaSource.lang.javaClass.util.Person"); // 通过类的全限定名得到该类class对象
        ClassLoader classLoader = forName.getClassLoader();
        System.out.println("该类的默认类加载器是" + classLoader);   //    AppClassLoader
    }

    @Test
    public void testNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> person = Class.forName("javaSource.lang.javaClass.util.Person"); // 通过类的全限定名得到该类class对象
        Person per = (Person) person.newInstance();  // 测试 newInstance 函数，返回一个object 对象，但是会知道对象的类型  javaSource.lang.javaClass.util.Person@5ce65a89
        per.display();
    }

    @Test  // 测试 getName 函数和 getDeclaredField 函数
    public void testGetNameAndDeclaredField() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> personClass = (Class<Person>) Class.forName("javaSource.lang.javaClass.util.Person"); // 通过类的全限定名得到该类class对象
        String name = personClass.getName();
        System.out.println("wgx----" + name);   // javaSource.lang.javaClass.util.Person 全路经名  Person

        Field declaredField = personClass.getDeclaredField("name");
//        System.out.println("Modifier before modify:"+declaredField + " ------------- " +declaredField.getModifiers());

        declaredField.setAccessible(true);

//        System.out.println("Modifier after modify:"+declaredField + " ++++++++++++++++ " +declaredField.getModifiers());

        Person person = new Person();
        person.setName("123");

        // 设置该user1的name属性
        Person person1 = personClass.newInstance();

        declaredField.set(person1, "wgx");   // 注意

        System.out.println(person.getName());
        System.out.println(person1.getName());
    }

    @Test  // 测试 getDeclaredMethod 函数
    public void testDeclaredMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> personClass = (Class<Person>) Class.forName("javaSource.lang.javaClass.util.Person"); // 通过类的全限定名得到该类class对象
        Method declaredMethod = personClass.getDeclaredMethod("display", null);
        declaredMethod.invoke(personClass.newInstance(), null);

        Method display = personClass.getDeclaredMethod("display", Integer.class, Integer.class);
        display.invoke(personClass.newInstance(), 1, 2);
    }

    @Test // 测试 getConstructor 函数
    public void testGetConstructor() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("javaSource.lang.javaClass.util.Person");
        Constructor<?> constructor = aClass.getConstructor(String.class, Integer.class);

        MyConstructAnnotation annotation = constructor.getAnnotation(MyConstructAnnotation.class);
        System.out.println(annotation);

        Class<?>[] parameterTypes = constructor.getParameterTypes();

        for (Class c : parameterTypes) {
            System.out.println(c.getName());
        }
    }

    @Test // 测试 getConstructor 函数
    public void testGetAnnotation() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("javaSource.lang.javaClass.util.Person");
        MyClassAnnotation annotation = aClass.getAnnotation(MyClassAnnotation.class);
        System.out.println(annotation);
    }

    @Test // 测试 cast 函数
    public void testCast() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("javaSource.lang.javaClass.util.Person");
        Son cast = (Son) aClass.cast(Son.class.newInstance());  // 类型转换，只能向下转
        System.out.println(cast);
    }

    @Test  // 测试 getPackage 函数
    public void test() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("javaSource.lang.javaClass.util.Person");
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage);
    }
}
