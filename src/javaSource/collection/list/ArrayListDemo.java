package javaSource.collection.list;

import javaSource.collection.util.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// ArrayList 测试 demo
public class ArrayListDemo {

    private List<Person> personList;

    @Test
    public void testStrem() {
        List<String> stringList = new ArrayList(); // 底层是维护一个数组，所以list下面地实现类都是有序，可以重复的。
        stringList.add("wgx");
        stringList.add("qaz");
        stringList.add("plm");

        /**
         * 这个方法的底层是使用了下面的方法。
         * public static native void arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
         * src： 源数组
         * srcPos：源数组开始复制的起始位置
         * dest ：目标数组、
         * destPos：：目标数组开始复制的起始位置
         * length：指的是在源数组中需要复制的长度
         */
        stringList.add(2, "wsx");

        boolean empty = stringList.isEmpty();
        System.out.println("is empty" + empty);

        int size = stringList.size();
        System.out.println("size--->" + size);

        Stream<String> stream = stringList.stream();
        stream.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s == "wgx") {
                    return false;
                }
                return true;
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 第二种流的遍历方式
        stream.filter((string) -> {
            if (string == "123") {
                return false;
            }
            return true;
        }).forEach((str) -> {
            System.out.println(str);
        });

        // map 可以映射初集合中每一个对象
        stringList.stream().map(String::toUpperCase).filter((str) -> {
            if (str.equals("WGX")) return false;
            else return true;
        }).collect(Collectors.toList()).forEach((string) -> {
            System.out.println(string);
        });

        // 去除重复的数据
        stringList.stream().distinct().forEach((str) -> {
            System.out.println(str);
        });

    }

    @Test
    public void test(){
        personList = new ArrayList<>();
        personList.add(new Person("wgx",24));
        personList.add(new Person("qaz",25));

        Iterator<Person> iterator = personList.iterator();
        iterator.forEachRemaining(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });

        //personList.clear(); 将集合数据清空
        String string = personList.toString();
        System.out.println(string);  // [Person{name='wgx', age=24}, Person{name='qaz', age=25}] 看的出来是一个数组

        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person one, Person two) {
                if (one.getAge() > two.getAge()){
                    return -1;
                }
                return 0;
            }
        });

        ListIterator<Person> personListIterator = personList.listIterator();
        personListIterator.forEachRemaining(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
        List<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("qaz",25));
        personList1.add(new Person("wgx",24));
        boolean b = personList.containsAll(personList1);  // 底层是比较hash值，即使：比较对象的equals 方法
        System.out.println(b);

//        personList1.set() 将新元素代替老元素，并返回老元素
    }
}
