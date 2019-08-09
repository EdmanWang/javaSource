package javaSource.concurrect;

import org.junit.Test;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    @Test
    public void test() throws InterruptedException {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        synchronousQueue.put("123"); // 队列中只允许有一个元素存在
    }

    public static void main(String[] args) {
        System.out.println("start");

        Thread.interrupted();

        System.out.println("end");
    }
}
