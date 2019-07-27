package javaSource.collection.set;

import javaSource.collection.util.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Stream;

// TreeSet 测试demo

/**
 * TreeSet:里面的元素不能重复，是因为底层拥一个map去维护的，添加的值，做我map的key
 */
public class TreeSetDemo {

    @Test
    public void test() {
        TreeSet treeSet = new TreeSet(new Comparator<Person>() {
            @Override
            public int compare(Person onePerson, Person twoPerson) {
                if (onePerson.equals(twoPerson)) {
                    return 0;  // 返回0的话就不会放在set集合里面
                } else if (onePerson.getAge() > twoPerson.getAge()) {
                    return 1;  // 按照升序规则排序
                } else if (onePerson.getAge() == twoPerson.getAge()) { // 如果对象的age属性值相等的话，
                    int i = onePerson.getName().compareTo(twoPerson.getName()); //就是按照姓名的规则按照字母顺序升序排序
                    if (i > 0) {
                        return 1;
                    }
                    return -1;
                } else {
                    return -1;
                }
            }
        });

        Person personOne = new Person("a", 11);
        Person personTwo = new Person("ab", 12);
        Person personThree = new Person("abc", 13);
        Person personFour = new Person("abcd", 14);

        treeSet.add(personOne);
        treeSet.add(personTwo);
        treeSet.add(personThree);
        treeSet.add(personFour);


        // 第一种迭代方式
//        iterator.forEachRemaining(new Consumer<Person>() {
//            @Override
//            public void accept(Person o) {
//                System.out.println(o);
//            }
//        });
////         第二种迭代方式
//        iterator.forEachRemaining((person)->{  // person 的类型，java可以根据比较器推导出来
//            System.out.println(person);
//        });

        Comparator comparator = treeSet.comparator();
        System.out.println(comparator.getClass().getName()); // 得到比较器的名字


        TreeSet collections = new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        collections.add(new Person("wgx", 24));
        collections.add(new Person("wgx", 25));

        boolean b = treeSet.addAll(collections);
        System.out.println("add all" + b);

        int size = treeSet.size();
        System.out.println("size ---->  " + size);

        long one1 = System.nanoTime();
        Iterator iterator = treeSet.iterator();
        iterator.forEachRemaining((person) -> {  // person 的类型，java可以根据比较器推导出来
            System.out.println(person);
        });
        long one2 = System.nanoTime();
        System.out.println(one2 - one1); // 40421000


        long two1 = System.nanoTime();
        Spliterator spliterator = treeSet.spliterator(); // java 1.8 出来的方法
        spliterator.forEachRemaining(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
        long two2 = System.nanoTime();
        System.out.println(two2 - two1); //  934100  结论：并行迭代器的效率远远高于单行迭代器，推荐使用并行迭代器，软件需要跟上硬件发展的速度，充分利用软件的优势

        SortedSet sortedSet = treeSet.headSet(personThree); // 返回指定排序后指定元素前面的数据
        System.out.println(sortedSet);

        NavigableSet navigableSet = treeSet.headSet(personThree, true); // 输出的时候是否加上自己输出
        System.out.println(navigableSet);

        SortedSet sortedSet1 = treeSet.tailSet(personThree); // 返回指定排序后指定元素后面的数据，包含自己
        System.out.println(sortedSet1);

        SortedSet sortedSet2 = treeSet.tailSet(personThree, false); // 返回指定排序后指定元素后面的数据，不包含自己
        System.out.println(sortedSet2);

        Object o = treeSet.pollFirst(); // 会将目前集合中的第一个元素推出去，并返回该推出去的元素
        Object o2 = treeSet.pollFirst();
        Object first = treeSet.first();   // 只是会得到第一个元素
        System.out.println(o.toString());
        System.out.println(o2.toString());
        System.out.println(first.toString());
        Object o3 = treeSet.pollFirst();
        System.out.println(o3.toString());

        Iterator iterator1 = treeSet.descendingIterator(); // 倒序输出

        iterator1.forEachRemaining(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });

        Stream stream = treeSet.stream(); // java 1.8 出来的方法
        stream.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person o) {
                System.out.println(o);
            }
        });

    }
}
