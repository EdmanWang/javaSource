package javaSource.concurrect.executorService;

import javaSource.concurrect.util.Person;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

    @Test
    public void test() {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
//        scheduledExecutorService.schedule()
    }

    public static void main(String[] args) {

        Person person = new Person("001", "qaz");

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
                // 延时修改数据库信息
                person.setId("002");
                person.setName("wgx");

                System.out.println(person);
            }
        }, 3000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        },1000,5000,TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("456");
            }
        },1000,5000,TimeUnit.MILLISECONDS);


//        scheduledExecutorService.shutdown();
    }
}
