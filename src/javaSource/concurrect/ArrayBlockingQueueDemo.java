package javaSource.concurrect;

import javaSource.concurrect.util.Consumer;
import javaSource.concurrect.util.Producter;
import org.junit.Test;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// ArrayBlockingQueue 测试 demo
public class ArrayBlockingQueueDemo {

    @Test
    public void test() throws InterruptedException {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue(1024);
        blockingQueue.put("wgx"); // 当底层的数组已经满的时候，会发生阻塞，并且会抛出异常
        boolean qaz = blockingQueue.add("qaz");
        System.out.println(qaz);
        Object take = blockingQueue.take(); // 当底层的数组是孔的时候，会发生阻塞，并且会抛出异常
        boolean wgx = blockingQueue.contains("wgx");
        int i = blockingQueue.drainTo(new HashSet<Object>(), 1);
        System.out.println(i);
        System.out.println(blockingQueue.size());

        blockingQueue.remainingCapacity();
    }

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(1024);

        Producter producter = new Producter(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        producter.start();
        consumer.start();
    }
}
