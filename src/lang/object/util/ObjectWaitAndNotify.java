package lang.object.util;

// 测试object基类的 wait 方法和notify 和notifyAll 方法
public class ObjectWaitAndNotify {

    public final static Integer MAX_COUNT = 20;

    public Integer productCount = 0;

    public synchronized void product() throws InterruptedException {  // java 中的锁 【synchronized】 是在并发访问共享资源保护的一种保护工具
        while (true) {   // 这个例子中需要保护的共享资源就是productCount
            System.out.println(Thread.currentThread().getName() + ":::run:::" + productCount);
            Thread.sleep(10);
            if (productCount >= MAX_COUNT) {
                System.out.println("产品已达上线.........");
                wait(); // 让执行这个方法的线程释放拥有的productCount 锁资源
            } else {
                productCount++;
            }
            notifyAll(); // 通知其他的线程执行
        }
    }

    public synchronized void consumer() throws InterruptedException {
        while (true) {
            System.out.println(Thread.currentThread().getName() + ":::run:::" + productCount);
            Thread.sleep(10);
            if (productCount <= 0) {
                System.out.println("已经没有产品消费了.........");
                wait(); // 让执行这个方法的线程释放拥有的productCount 锁资源
            } else {
                productCount--;
            }
            notifyAll(); // 通知其他的线程执行
        }
    }
}
