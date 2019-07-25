package javaSource.io.byteStream.inputstream;

import javaSource.io.byteStream.inputstream.util.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 主要的作用是用于写入对象信息与读取对象信息。 对象信息一旦写到文件上那么对象的信息就可以做到持久化了
 * 将序列化的二进制文件反序列化成对象
 */
public class ObjectInputStreamDemo {

    @Test // 对象反序列化的过程
    public void testReadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("D:\\person.txt")));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);
    }

    @Test // 测试available
    public void testavailable() throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("D:\\person.txt")));
        int available = objectInputStream.available();
        System.out.println("available read byte number---->" + available);
    }
}
