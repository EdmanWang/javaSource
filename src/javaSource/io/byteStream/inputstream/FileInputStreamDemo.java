package javaSource.io.byteStream.inputstream;

import org.junit.Test;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

// 测试 FileInputStream 文件读出流
public class FileInputStreamDemo {

    //  FileInputStream 继承 文件输入流的基类 inputStream

    @Test // 测试一次读取一个字节  read 函数
    public void testRead() throws IOException {
        long before = System.nanoTime();
        // 文件需要指定到classpath 下的具体的目录
       //  FileInputStream fileInputStream = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        FileInputStream fileInputStream = new FileInputStream("D:\\Person.class");
        int index; // 流的读取索引
        while ((index = fileInputStream.read()) != -1) {
            System.out.println("index" + index);
        }
        long after = System.nanoTime();
        System.out.println("需要的时间差----" +( after - before));  // 5231900
        fileInputStream.close();
    }

    @Test // 测试一次读取一个字节  read 函数
    public void testReadBytes() throws IOException {
        long before = System.nanoTime();
        // 文件需要指定到classpath 下的具体的目录
        FileInputStream fileInputStream = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        byte[] bytes = new byte[1024];

        int read = fileInputStream.read(bytes);  // 返回的int 类型的参数read 表示这次读取的字节的长度
        System.out.println("total read bytes " + read);

        long after = System.nanoTime();

        System.out.println("需要的时间差----" +( after - before));  //   132500

        fileInputStream.close();
    }

    @Test // 测试文件描述器  FileDescriptor
    public void testGetFD() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/javaSource/io/inputstream/util/wgx.txt");
        FileDescriptor fd = fileInputStream.getFD();
        SecurityManager security = System.getSecurityManager();
        System.out.println("security-----" + security);
        System.out.println("fd-----" + fd);
        fileInputStream.close();
    }
}
