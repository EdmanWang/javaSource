package javaSource.collection.list;

import javaSource.collection.util.Person;
import org.junit.Test;

import java.util.Stack;

// stack 测试 deno
public class StackDemo {

    @Test
    public void test() {
        Stack stack = new Stack();

        stack.push(new Person("wgx", 23));  // 进栈
        stack.push(new Person("qaz", 24));  // 进栈

        int qaz = stack.search(new Person("qaz", 24)); // 查找的是对象地hash值
        System.out.println(qaz);

//        Object pop = stack.pop();  // 出栈,并删除栈顶元素
//        System.out.println(pop.toString());
//        System.out.println(stack.size());

        Object peek = stack.peek(); // 出栈，但是不删除栈定元素
        System.out.println(peek.toString());
        System.out.println(stack.size());
    }
}

