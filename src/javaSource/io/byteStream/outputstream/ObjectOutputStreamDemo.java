package javaSource.io.byteStream.outputstream;

import javaSource.io.byteStream.inputstream.util.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象的持久化过程
 */
public class ObjectOutputStreamDemo {

    @Test // 测试将对象持久化（持久化）到文件当中去 。成二进制
    public void testWriteObject() throws IOException {
        Person person = new Person("wgx","123456");

        File file = new File("D:\\person.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);

        objectOutputStream.close();
    }
}
