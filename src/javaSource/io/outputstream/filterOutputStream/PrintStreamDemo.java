package javaSource.io.outputstream.filterOutputStream;

// 字符打印流

import javaSource.lang.object.util.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo {

    @Test
    public void test() throws FileNotFoundException {
        File file = new File("src/javaSource/io/outputstream/util/wgx.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        PrintStream printStream = new PrintStream(fileOutputStream, true);
        printStream.println("wgx123");
        printStream.println(1);
        printStream.print(1235l);
        printStream.print(new Person("123","wgx"));
    }
}
