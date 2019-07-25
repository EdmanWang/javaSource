package javaSource.io.charStream.reader;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

//字符写入回退流
public class PushbackReaderDemo {

    @Test
    public void test() throws IOException {
        PushbackReader pushbackReader = new PushbackReader(new BufferedReader(new InputStreamReader(new FileInputStream("src/javaSource/io/charStream/reader/util/wgx.txt"))));
        int read = pushbackReader.read();
        System.out.println("111" + (char) read);
        pushbackReader.unread(8169);
        int read1 = pushbackReader.read();
        System.out.println("222" + (char) read1);
    }
}
