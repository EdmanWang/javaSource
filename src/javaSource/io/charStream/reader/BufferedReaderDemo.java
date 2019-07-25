package javaSource.io.charStream.reader;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.stream.Stream;

// bufferefWrite 字符读出缓冲流
public class BufferedReaderDemo {

    @Test
    public void testLines() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/javaSource/io/charStream/reader/util/wgx.txt"))));
        Stream<String> lines = bufferedReader.lines(); // 直接是读出全部的行
        long count = lines.count();  // 得出行数
        // 第一种方式
        lines.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 函数式表达
        lines.forEach(string -> {
            System.out.println(string);
        });
    }

    @Test // 读一个字符
    public void testRead() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/javaSource/io/charStream/reader/util/wgx.txt"))));
        int read = bufferedReader.read();
        System.out.println("read one" + (char) read);
    }

    @Test //
    public void testReadLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/javaSource/io/charStream/reader/util/wgx.txt"))));
        String string = bufferedReader.readLine();
        System.out.println("read line" + string);
    }

    @Test // 读一行字符
    public void testReadChars() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/javaSource/io/charStream/reader/util/wgx.txt"))));
        char[] chars = new char[3];
        int read = bufferedReader.read(chars, 0, chars.length);
        System.out.println(read);
        for (char c: chars){
            System.out.println(c);
        }
    }

    @Test
    public void test() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/javaSource/io/charStream/reader/util/wgx.txt"))));
        String stringOne = bufferedReader.readLine();
        System.out.println("read line" + stringOne);
        bufferedReader.mark(0);
        bufferedReader.reset();
        String stringTwo = bufferedReader.readLine();
        System.out.println("read line" + stringTwo);
    }
}
