package javaSource.concurrect.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producter extends Thread {

    private BlockingQueue<String> arrayBlockingQueue;

    public Producter(BlockingQueue<String> arrayBlockingQueue1){
        this.arrayBlockingQueue = arrayBlockingQueue1;
    }

    @Override
    public void run() {
        try {
            arrayBlockingQueue.put("wgx");
            Thread.sleep(800);
            arrayBlockingQueue.add("qaz");
            Thread.sleep(1200);
            arrayBlockingQueue.add("123");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
