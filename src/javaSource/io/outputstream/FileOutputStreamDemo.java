package javaSource.io.outputstream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

// 文件写入流---到到指定的文件 文件写入流
public class FileOutputStreamDemo {

    @Test // 写入一个字节数组，默认是不追加
    public void testReadBytes() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/javaSource/io/outputstream/util/wgx.txt", true);
        byte[] bytes = new byte[]{'a', 'w'};
        fileOutputStream.write(bytes, 0, bytes.length);
        fileOutputStream.close();
    }

    @Test //向文件写入一个字符，默认是不追加
    public void testRead() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/javaSource/io/outputstream/util/wgx.txt", true);
        fileOutputStream.write(97);
        fileOutputStream.close();
    }
}
