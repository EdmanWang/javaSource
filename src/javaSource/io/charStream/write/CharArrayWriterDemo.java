package javaSource.io.charStream.write;

import org.junit.Test;

import java.io.CharArrayWriter;

// 字符数组写入流
public class CharArrayWriterDemo {

    @Test
    public void test(){  // 将数据写入一个字符数组中
        CharArrayWriter charArrayWriter = new CharArrayWriter(1024);
        charArrayWriter.write(97);
//        char[] chars = charArrayWriter.toCharArray();
//        System.out.println(chars[0]);
        charArrayWriter.close();
        charArrayWriter.write(98);  // 关闭流不起作用
        char[] chars = charArrayWriter.toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars[1]);
    }
}
