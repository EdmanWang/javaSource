package javaSource.concurrect.locks;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.concurrent.locks.StampedLock;

// StampedLock  测试 demo  java8 引入
public class StampedLockDemo {

    /**
     * 1:StampedLock 类在 Java 8中引入，同样支持读锁和写锁，不同的是获取锁的方法返回一个用于释放锁或检查锁是否有效的标记:
     * 2:StampedLock 的另一个特点是采用了乐观锁策略，大部分的时间里读操作不需要等待写操作的完成，因此不需要一个完善的读锁，相反可以升级到读锁
     */

    StampedLock stampedLock = new StampedLock();

    /**
     * 从文件中进行的读操作
     *
     * @param file
     */
    public void readFile(File file) {
        long readLock = stampedLock.readLock();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = bufferedReader.readLine();
            System.out.println("readLine----" + line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockRead(readLock);
        }
    }

    /**
     * 在文件中的写入操作
     *
     * @param file
     * @param string
     */
    public void writeFile(File file, String string) {
        /**
         * 和读写锁的区别是，StampedLock 不管是读还是写锁都有一个返回值
         */
        long writeLock = stampedLock.writeLock();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FilterOutputStream(new FileOutputStream(file, true))));
            bufferedWriter.write(string);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockWrite(writeLock);
        }
    }

    public static void main(String[] args) {
        StampedLockDemo stampedLockDemo = new StampedLockDemo();

        File file = new File("src/javaSource/concurrect/locks/util/person.txt");

        new Thread(new Runnable() {
            @Override
            public void run() {
                stampedLockDemo.readFile(file);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                stampedLockDemo.readFile(file);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                stampedLockDemo.writeFile(file, "wgx01");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                stampedLockDemo.writeFile(file, "wgx02");
            }
        }).start();
    }
}
