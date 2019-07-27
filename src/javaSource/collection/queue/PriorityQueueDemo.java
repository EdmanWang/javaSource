package javaSource.collection.queue;

import org.junit.Test;

import java.util.PriorityQueue;

// PriorityQueue 测试  demo
public class PriorityQueueDemo {

    @Test
    public void test(){
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("wgx01");
        priorityQueue.add("wgx02");
        priorityQueue.add("wgx03");

        String poll = priorityQueue.poll();
        System.out.println(poll);
    }
}
