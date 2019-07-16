package lang.object;

import lang.object.util.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectDemo {

    public static void main(String[] args) {
        System.out.println("1111");
        // 创建一个对象
        Person person = new Person();
        // 得到一个class对象
        Class<? extends Person> personClass = person.getClass();

        // 通过的到的class对象，做相关操作。

        ClassLoader classLoader = personClass.getClassLoader();
        System.out.println("ClassLoader ----->" + classLoader);

        // 得到person类声明的全部字段
        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field field : declaredFields){
            System.out.println("field---->"+field);
        }

        // 得到person类的全部都构造函数
        Constructor<?>[] personClassConstructors = personClass.getConstructors();
        for (Constructor constructor:personClassConstructors){
            System.out.println("constructor---->"+constructor);
        }

        // 得到person类全部的方法
        Method[] personClassMethods = personClass.getMethods();
        for (Method method:personClassMethods){
            System.out.println("method---->"+method);
        }

    }
}
