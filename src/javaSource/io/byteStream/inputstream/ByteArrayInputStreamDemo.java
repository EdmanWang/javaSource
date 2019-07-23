package javaSource.io.inputstream;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

//  内存读出流
// 最关键的地方是在关闭流的时候，不起作用
public class ByteArrayInputStreamDemo {

    @Test
    public void test() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("abc".getBytes());
        int read1 = byteArrayInputStream.read();
        byteArrayInputStream.close();   // 此处关闭内存流是不起作用的
        int read2 = byteArrayInputStream.read(); // 还是可以读出数据
        System.out.println(read1);
        System.out.println(read2);
    }
}
