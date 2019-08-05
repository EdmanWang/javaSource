package javaSource.concurrect;

import javaSource.concurrect.util.delayQueueOne.Consumer;
import javaSource.concurrect.util.delayQueueOne.Message;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// DelayQueue  测试 demo
public class DelayQueueDemo {

    @Test
    public void test() throws InterruptedException {

    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue<Message>();

        delayQueue.put(new Message(1,"qaz",2000));
        delayQueue.put(new Message(2,"wgx",5000));
        delayQueue.put(new Message(3,"123",8000));


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Consumer(delayQueue));

//        executorService.shutdownNow();
    }
}
