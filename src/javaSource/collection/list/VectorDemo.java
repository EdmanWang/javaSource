package javaSource.collection.list;

import javaSource.collection.util.Person;
import org.junit.Test;

import java.util.Vector;

// Vector 测试 demo  vector 相比较arrayList来说，最重要地特点就是，全部的方法都是线程安全的
// 其他地基本上就和arrayList 一样的。
public class VectorDemo {

    @Test
    public void test() {
        Vector vector = new Vector();
        vector.add(new Person("wgx", 24)); // 底层是一个数组
    }
}
