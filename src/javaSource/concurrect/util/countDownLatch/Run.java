package javaSource.concurrect.util.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Run implements Runnable{

    private CountDownLatch countDownLatch;

    public Run(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            countDownLatch.countDown();
            Thread.sleep(5000);
            countDownLatch.countDown();
            Thread.sleep(8000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
