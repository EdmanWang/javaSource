package javaSource.collection.list;

// LinkedList 测试 demo  底层是维护一个链表，即：node节点

import org.junit.Test;

import java.util.LinkedList;
import java.util.Spliterator;

/**
 * 1：除了头节点和尾节点，每一个节点都有一个前去和后继
 * 2: 头节点只有一个后继
 * 3：尾节点只有一个前驱
 */
public class LinkedListDemo {

    @Test
    public void test() {
        LinkedList linkedList = new LinkedList<String>();
        linkedList.add("wgx01");  // 从0 开始计数
        linkedList.add("wgx02");   // 从链表尾添加数据
        linkedList.add(1, "wgx03"); // 在链表中的某一个位置插入数据

        int size = linkedList.size();
        System.out.println("size--->" + size);
//        linkedList.addAll()
//        linkedList.get()
//        Object element = linkedList.element();  // 返回第一个元素但是不删除元素,会抛出异常
//        System.out.println(element);
//        System.out.println(linkedList.getFirst());
        boolean wgx04 = linkedList.offer("wgx04");
        System.out.println(wgx04);
        Object element = linkedList.element();  // 返回第一个元素但是不删除元素,会抛出异常
        Object peek = linkedList.peek();  // 返回第一个元素但是不删除元素,不会抛出异常，没有值得时候，就是会返回null
        Object poll = linkedList.poll();  // 返回第一个元素并且删除元素
        System.out.println(poll);
//        linkedList.push();  向链表头添加元素
//        linkedList.remove()
//        linkedList.pop()
        Spliterator spliterator = linkedList.spliterator(); // 并行迭代器
        spliterator.forEachRemaining((str)->{
            System.out.println(str);
        });
    }

    @Test
    public void testAddAllSuccess() { // 测试集合里每一条数据都操作成功的方案,这就是思想
//        boolean modified = false;
//        for (E e : c)
//            if (add(e))
//                modified = true;
//        return modified;
    }
}
