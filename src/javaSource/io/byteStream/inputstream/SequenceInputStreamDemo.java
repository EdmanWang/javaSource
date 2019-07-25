package javaSource.io.byteStream.inputstream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 测试  SequenceInputStream
 * 串型流
 */
public class SequenceInputStreamDemo {
    Enumeration<? extends InputStream> e;

    @Test   // 问题：为什么vector.elements() 的时候会返回一个vector类型
    public void test() throws IOException {
        InputStream inputStreamOne = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        InputStream inputStreamTwo = new FileInputStream("src/javaSource/io/inputstream/util/qaz.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreamOne, inputStreamTwo);

        Integer count;
        while ((count = sequenceInputStream.read()) != -1) {
            System.out.println("read one by one" + count);

        }
    }

    @Test
    public void testVectorElements() {
        Enumeration<? extends InputStream> type;
        Vector<InputStream> vector = new Vector<InputStream>(2);
        type = vector.elements();
        System.out.println("type 的类型是------->" + type.toString());
    }

    @Test
    public void testVector() {
        Vector<String> v = new Vector<String>();

        v.addElement("abc1");
        v.addElement("abc2");
        v.addElement("abc3");
        v.addElement("abc4");

        System.out.println(v.getClass().getName());

        Enumeration<String> en = v.elements();
        System.out.println(en.getClass().getName());

        Enumeration<String> en1 = v.elements();
        System.out.println(en1.getClass().getName());

        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }

    public static Runnable test11() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("HI");
            }
        };
    }

}
