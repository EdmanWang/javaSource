package javaSource.collection.queue;

import org.junit.Test;

import java.util.ArrayDeque;

// ArrayDeque 测试 demo 底层就是一个数组,功能没有多大的变化
public class ArrayDequeDemo {

    @Test
    public void test(){
        ArrayDeque arrayDeque = new ArrayDeque<String>();
        arrayDeque.add("wgx");
    }
}
