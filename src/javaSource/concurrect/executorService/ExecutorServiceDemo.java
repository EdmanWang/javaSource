package javaSource.concurrect.executorService;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

// ExecutorService 测试 demo
public class ExecutorServiceDemo {

    /**
     * 线程池的基类是 Executor 需要实现一个函数 execute
     * ThreadPoolExecutor 继承 AbstractExecutorService
     * ScheduledThreadPoolExecutor 继承  ThreadPoolExecutor 实现 ScheduledExecutorService
     *
     * 在使用线程池的时候，可以使用 Executors 类的相关方法去实现线程池的创建，底层其实就是创建了一系列的  ThreadPoolExecutor
     */

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        ExecutorService service = Executors.newFixedThreadPool(5);

        Executors.newCachedThreadPool();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("789");
            }
        });
        System.out.println(threadFactory);

        executorService.execute(() -> {
            System.out.println("我在执行01");
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("我在执行03");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我在执行02");
            }
        });

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("我在执行04");
                return "我在执行04";
            }
        });
        future.isDone();

        executorService.submit(() -> {
            System.out.println("我在执行05");
            return "123";
        });

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(() -> {
            return "003";
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "004";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "001";
            }
        });
        callables.add(() -> {
            return "002";
        });

        /**
         * 只是会执行其中的一个Callable，就会立即返回
         */
        String invokeAny = executorService.invokeAny(callables);
        System.out.println(invokeAny);

        Set<Callable<String>> callableSet = new HashSet<>();
        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "123";
            }
        });
        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "456";
            }
        });
        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "789";
            }
        });
        List<Future<String>> futures = executorService.invokeAll(callableSet, 2000, TimeUnit.MILLISECONDS);

        futures.stream().forEach((stringFuture) -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void test01(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("123123");
            }
        },3000,TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("qqqqqq");
            }
        },3000,TimeUnit.MILLISECONDS);
    }
}
