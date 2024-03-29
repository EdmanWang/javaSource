package javaSource.concurrect.util.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable{

    private CountDownLatch countDownLatch;

    public Waiter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待结束，我要执行了");
    }
}
