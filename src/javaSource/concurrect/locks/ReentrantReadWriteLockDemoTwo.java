package javaSource.concurrect.locks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PublicKey;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 总结： 同一时刻，只能有写入线程
 * 但是在在同一时刻可以有多个读取线程
 */
public class ReentrantReadWriteLockDemoTwo {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 向文件中写入数据
    public void writeFile(File file, byte a) {
        readWriteLock.writeLock().lock();
        try {
            OutputStream outputStream = new FileOutputStream(file, true);
            outputStream.write(a);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();  // 一次只有一个线程拥有执行资格
        }
    }

    // 从文件中读取数据
    public void readFile(File file) {
        readWriteLock.readLock().lock();
        try {
            InputStream inputStream = new FileInputStream(file);
            int read = inputStream.read();
            System.out.println("read----------" + read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("src/javaSource/concurrect/locks/util/person.txt");
            ReentrantReadWriteLockDemoTwo writeLockDemoTwo = new ReentrantReadWriteLockDemoTwo();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    byte write = 97;
                    writeLockDemoTwo.writeFile(file, write);
                    System.out.println("write=====1");
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    writeLockDemoTwo.readFile(file);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    writeLockDemoTwo.readFile(file);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    writeLockDemoTwo.readFile(file);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    byte write = 97;
                    writeLockDemoTwo.writeFile(file, write);
                    System.out.println("write=====1");
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    byte write = 98;
                    writeLockDemoTwo.writeFile(file, write);
                    System.out.println("write=====2");
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
