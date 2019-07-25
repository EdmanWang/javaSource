package javaSource.io.charStream.write;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

// 字符打印写入流demo
public class PrintWriterDemo {

    @Test
    public void test() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("src/javaSource/io/charStream/write/util/wgx.txt"); // 注意几个构造方法
        // 都是父类的方法 一个具体的实现
    }
}
