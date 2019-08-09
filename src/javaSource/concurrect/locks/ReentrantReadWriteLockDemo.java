package javaSource.concurrect.locks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

// ReentrantReadWriteLock 测试 demo
public class ReentrantReadWriteLockDemo {


    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 读锁
    Lock readLock = readWriteLock.readLock();

    // 写锁
    Lock writeLock = readWriteLock.writeLock();

    public void writeOne(Map<String, String> map) {
        writeLock.lock();
        try {
            map.put("wgx01", "123");
        } finally {
            writeLock.unlock();
        }
    }

    public void writeTwo(Map<String, String> map) {
        writeLock.lock();
        try {
            map.put("wgx02", "456");
        } finally {
            writeLock.unlock();
        }
    }

    public String readOne(Map<String, String> map) {
        readLock.lock();
        try {
            String s = map.get("wgx01");
            return s;
        } finally {
            readLock.unlock();
        }
    }

    public String readTwo(Map<String, String> map) {
        readLock.lock();
        try {
            String s = map.get("wgx02");
            return s;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo readWriteLockDemo = new ReentrantReadWriteLockDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Map<String, String> map = new HashMap<>();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("write----one");
                readWriteLockDemo.writeOne(map);
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("write----two");
                readWriteLockDemo.writeTwo(map);
            }
        });

        System.out.println(map.size());
//        map.put("wgx02","1234");
//        map.put("wgx03","12345");

//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                String s = readWriteLockDemo.readOne(map);
//                System.out.println(s);
//            }
//        });
////
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                String s = readWriteLockDemo.readTwo(map);
//                System.out.println(s);
//            }
//        });
        executorService.shutdown();
    }
}
