package javaSource.concurrect.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 理解锁的概念
 * 1：在某一个类里面创建一个锁的对象
 * <p>
 * 理解java锁的存在
 * java中锁所持有的资源指的是，对象（即：是new出来的对象）,或者其他方式 实例化出来的对象，【1：反射 2：clone 】
 */
public class ReentrantLockDemo {

    ReentrantLock lock = new ReentrantLock(true);

    int count = 0;

    public int addCount() throws InterruptedException {
        //lock.lock();  // 此处的方法指的是，会一直持有该锁资源【对象】。另外一个线程来的时候，会发生只是阻塞。
        //boolean b = lock.tryLock();// 此处的方法指的是，会尝试着将锁资源锁住【对象】，如果发现锁不住，就直接放行
        // boolean b = lock.tryLock(5000, TimeUnit.MILLISECONDS);  // 在规定的时间将锁资源【对象】锁住，超出时间后直接放行
        lock.lockInterruptibly();
        try {
            count++;
        } finally {
//            lock.unlock();  // 所谓的释放锁，就是说线程放弃持有这段锁,【就是释放对象】，当放弃以以后，其他的线程（人）就可以去获得该资源
            return count;
        }
    }

    public int subCount() {
//        lock.lock();
        return --count;
    }

    public void show() {
        System.out.println(count++);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ReentrantLockDemo reentrantLockDemo01 = new ReentrantLockDemo();   // 这里的每一个对象才是锁所对应的资源

        ReentrantLockDemo reentrantLockDemo02 = new ReentrantLockDemo();

        ReentrantLockDemo reentrantLockDemo03 = ReentrantLockDemo.class.newInstance();

        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 在同一个线程里面，
                 */
                System.out.println("thread name 001" + Thread.currentThread().getName());
                try {
                    System.out.println(reentrantLockDemo01.addCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(reentrantLockDemo01.subCount());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name 002" + Thread.currentThread().getName());

                /**
                 * 在没有再次访问锁持有的资源的时候，其他的方法还是可以走
                 */
                try {
                    System.out.println(reentrantLockDemo01.addCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(reentrantLockDemo01.subCount());
                reentrantLockDemo02.show();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name 003" + Thread.currentThread().getName());
                reentrantLockDemo03.show();
                try {
                    System.out.println(reentrantLockDemo03.addCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(reentrantLockDemo03.subCount());
            }
        }).start();


    }

}
