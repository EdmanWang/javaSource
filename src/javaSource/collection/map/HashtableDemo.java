package javaSource.collection.map;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Hashtable;

// Hashtable 测试 demo

/**
 * Hashtable 实现了map接口但是是继承dictionary.
 * 1:Hashtable 有一个很重要的特点就是，它全部的方法都是线程安全的。这一点要区别于hashMap
 * 2:所以hashMap的执行效率要比hashTable快一些
 * 3:Hashtable默认的初始化最小的容量是11
 */
public class HashtableDemo {

    @Test
    public void test() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("wgx", "122");
        Enumeration<String> elements = hashtable.elements(); // 返回的是value的集合
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }

        // hashtable.values(); 这个函数底层还是和hashtable.elements() 是一样的

        /**
         * hashtable 中的方法其实和hashMap中的方法都是差不多的。没有多大区别，参考 hashMapDemo 中的测试
         */
    }
}
