package javaSource.concurrect;

import org.junit.Test;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

// PriorityBlockingQueue 【优先阻塞队列】测试demo
public class PriorityBlockingQueueDemo {

    @Test
    public void test(){
        /**
         * Comparator 决定了你在队列中添加元素的顺序
         */
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(16, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}
