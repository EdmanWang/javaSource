package javaSource.io.byteStream.inputstream.filterInputStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * 测试回退流的使用
 * PushbackInputStream 旨在从 InputStream 解析数据时使用。
 * 有时您需要先读取几个字节以查看将要发生的事情，然后才能确定如何解释当前字节，
 * PushbackInputStream 允许这样做。 实际上，它允许将读取的字节推回到流中，这样就像流没有被动过，
 * 下次调用 read() 时，将再次重新读取。
 * 通俗来讲，就像男人对女人(Stream）说：我只看看，不动手。
 */
public class PushbackInputStreamDemo {

    @Test
    public void testRead() throws IOException {
        InputStream in = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        PushbackInputStream pushbackInputStream = new PushbackInputStream(in, 2);

        int read = pushbackInputStream.read(); // 首先读取一个字节
        pushbackInputStream.unread(read);   // 回退

        int read1 = pushbackInputStream.read();
        System.out.println(read1);
    }

    @Test
    public void testReadBytes() throws IOException {
        InputStream in = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        PushbackInputStream pushbackInputStream = new PushbackInputStream(in,1024);

        byte[] bytes = new byte[10];
        int read = pushbackInputStream.read(bytes, 0, bytes.length);

        pushbackInputStream.unread(bytes, 0, bytes.length);

        int read01 = pushbackInputStream.read(); // 首先读取一个字节
        System.out.println(read01);
    }
}
