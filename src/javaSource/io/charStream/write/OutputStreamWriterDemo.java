package javaSource.io.charStream.write;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// 字符写入流
public class OutputStreamWriterDemo {

    @Test
    public void testEncoding() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("src/javaSource/io/charStream/write/util/wgx.txt", true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        String encoding = outputStreamWriter.getEncoding();  //encoding
        System.out.println("system default encoding ----> " + encoding); // 默认是UTF8
    }

    @Test
    public void testWriteOne() throws IOException {
        OutputStream outputStream = new FileOutputStream("src/javaSource/io/charStream/write/util/wgx.txt", true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(97); // 写一个字节
        outputStreamWriter.write(new char[]{'过','王'}); // 写一个字节数组
        outputStreamWriter.write(new char[]{'过','王'},0,1);  // 写一个字节数组
        outputStreamWriter.write("wgx");  // 写一个字符

        outputStreamWriter.close();
    }
}
