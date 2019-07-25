package javaSource.io.charStream.reader;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

// 字符读出流 测试demo
public class InputStreamReaderDemo {

    @Test
    public void testReadOne() throws IOException {
        // 当出现了中文的时候，就应该使用字符流，可以通过文件字节流转换成字符流
        InputStream inputStream = new FileInputStream(new File("src/javaSource/io/charStream/reader/util/wgx.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        String encoding = inputStreamReader.getEncoding();
        System.out.println("encoding---->" + encoding);  // 系统默认的编码方式是UTF-8
        System.out.println((char) inputStreamReader.read());
    }

    @Test  // 测试读一个字符数组
    public void testReadArray() throws IOException {
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();  // 系统支持的编码方式
        for (Map.Entry<String, Charset> entry : stringCharsetSortedMap.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        InputStream inputStream = new FileInputStream(new File("src/javaSource/io/charStream/reader/util/wgx.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        char[] chars = new char[10];
        int read = inputStreamReader.read(chars, 0, chars.length);
        System.out.println("read length---->" + read);
        for (char c : chars) {
            System.out.println(c);
        }
    }
}
