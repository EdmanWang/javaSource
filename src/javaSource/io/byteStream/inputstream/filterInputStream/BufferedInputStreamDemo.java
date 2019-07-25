package javaSource.io.byteStream.inputstream.filterInputStream;

// BufferedInputStream 测试demo

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 所谓的缓存流就是在原来的读取字节数组的基础上装饰了一下，使用到了装饰者模式
 * 主要使用的方式是 fill() 方法，即使先对字节数组进行填充。每次都是让其数组长度满了以后再去读取。
 */

public class BufferedInputStreamDemo {

    @Test // 测试 缓冲流每次读取一个字节所需要的是时间
    public void testRead() throws IOException {
        long before = System.nanoTime();
        InputStream inputStream = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int number;
        while ((number = bufferedInputStream.read()) != -1) { // 和普通的流相比是多了一个缓冲区
            System.out.println(number);
        }
        long after = System.nanoTime();

        System.out.println("需要的时间差----" +( after - before));   // 3410600 缓冲流 所需要的时间比普通流要少。
        bufferedInputStream.close();
    }

    @Test // 测试 缓冲流每次读取字节数组所需要的是时间
    public void testReadBytes() throws IOException {
        long before = System.nanoTime();
        InputStream inputStream = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[1024];  // 数据还是会先读取到这个字节数组中去
        int read = bufferedInputStream.read(bytes, 0, bytes.length);  // 总共读的字节数
        String string = new String(bytes,0,bytes.length,"utf-8");
        System.out.println(string);
        System.out.println("wgx----test"+read);
        long after = System.nanoTime();

        System.out.println("需要的时间差----" +( after - before));   // 结论：在数据量大的时候，缓冲流的效率更高。
        bufferedInputStream.close();
    }
}
