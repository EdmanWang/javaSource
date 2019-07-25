package javaSource.io.charStream.write;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

// 字符文件写入流
public class FileWriterDemo {

    @Test
    public void test() throws IOException {
        FileWriter fileWriter = new FileWriter("src/javaSource/io/charStream/write/util/wgx.txt");
        // 全是父类 outputStreamWrite中的方法
    }
}
