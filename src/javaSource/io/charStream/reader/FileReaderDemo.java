package javaSource.io.charStream.reader;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

// 字符文件读出流
public class FileReaderDemo {

    @Test
    public void test() throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/javaSource/io/charStream/reader/util/wgx.txt");
        // 全是父类中继承的方法
    }

}
