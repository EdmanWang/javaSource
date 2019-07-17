package javaSource.lang.genericity;

import javaSource.lang.genericity.util.Info;
import javaSource.lang.genericity.util.InfoImpl;
import javaSource.lang.genericity.util.Person;
import javaSource.lang.genericity.util.User;
import org.junit.Test;

// 泛型测试demo
public class GenericityDemo {

    @Test // 测试泛型类
    public void testGenericityClass() {
        // 测试泛型类的时候，需要在实例化的时候指定泛型的类型
        Person<String, Integer> person = new Person<String, Integer>();  // 泛型类等号右边的类型指定可以不写  Person<String,Integer> person = new Person<>();
        person.setTl("wgx");
        person.setT2(24);
        System.out.println(person.getTl() + "-----" + person.getT2());
    }

    @Test // 测试泛型方法的使用
    public void testGenericityMethod() throws InstantiationException, IllegalAccessException {
        // 测试泛型类的时候，需要在实例化的时候指定泛型的类型
        Person<Integer, Integer> person = new Person<>();  // 泛型类等号右边的类型指定可以不写  Person<String,Integer> person = new Person<>();
        person.setTl(2);
        person.setT2(24);
        System.out.println(person.getTl() + "-----" + person.getT2());
        // 测试泛型方法的使用，不需要传入泛型的类型，java虚拟机会自动去识别类型
        //person.display01(person.getTl(), person.getT2());
        User user = new User("wgx", 24);
        person.display(user, "qaz");
    }

    @Test // 测试泛型接口的使用
    public void testGenericityInterface() {
        Info<String> info = new InfoImpl<String>("wgx");
        String val = info.getVal();
        System.out.println(val.length());
    }
}
