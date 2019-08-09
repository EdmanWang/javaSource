package javaSource.concurrect;

import javaSource.concurrect.util.countDownLatch.Run;
import javaSource.concurrect.util.countDownLatch.Waiter;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

// CountDownLatch【闭锁】 测试 demo
public class CountDownLatchDemo {

    @Test
    public void test() {

    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(new Run(countDownLatch)).start();
        new Thread(new Waiter(countDownLatch)).start();  //只有当闭锁计数器小于等于0的时候，才会执行
    }
}
