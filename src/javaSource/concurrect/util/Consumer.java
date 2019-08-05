package javaSource.concurrect.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
    private BlockingQueue<String> arrayBlockingQueue;

    public Consumer(BlockingQueue<String> arrayBlockingQueue1) {
        this.arrayBlockingQueue = arrayBlockingQueue1;
    }

    @Override
    public void run() {
        try {
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
