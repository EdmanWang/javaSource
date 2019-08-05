package javaSource.concurrect;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

// LinkedBlockingQueue 测试 demo
public class LinkedBlockingQueueDemo {

    @Test
    public void test() throws InterruptedException {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.put("wgx");
    }
}
