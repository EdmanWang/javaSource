package javaSource.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

// HashSet 测试 demo

/**
 * HashSet:里面的元素不能重复，是因为底层拥一个map去维护的，添加的值，做我map的key
 */
public class HashSetDemo {

    @Test
    public void test() {
        HashSet hashSet = new HashSet();
        hashSet.add("wgx");
        hashSet.add("qaz");
        Iterator iterator = hashSet.iterator();
        iterator.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        });

        int size = hashSet.size();
        System.out.println("size" + size);

//        hashSet.spliterator() 并行迭代器
//        hashSet.clear();
        int size01 = hashSet.size(); // 将集合清空
        System.out.println("size" + size01);

        boolean wgx = hashSet.contains("wgx");
        System.out.println("contains wgx" + wgx);

        HashSet clone = (HashSet)hashSet.clone(); // 复制出对象
        System.out.println(clone.getClass().getName());
        System.out.println(clone.size());
        Spliterator spliterator = clone.spliterator();
        spliterator.forEachRemaining((str)->{
            System.out.println(str);
        });

        boolean qaz = hashSet.remove("qaz");
        System.out.println(qaz);

        Iterator iterator01 = hashSet.iterator();
        iterator01.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        });

    }
}
