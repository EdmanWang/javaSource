package javaSource.concurrect.util.delayQueueOne;

import java.util.concurrent.DelayQueue;

public class Consumer implements Runnable {

    private DelayQueue<Message> delayQueue;

    public Consumer(DelayQueue<Message> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message take = delayQueue.take();
                System.out.println("消费消息id：" + take.getId() + " 消息体：" + take.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
