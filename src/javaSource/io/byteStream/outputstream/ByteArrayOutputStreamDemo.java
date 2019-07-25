package javaSource.io.byteStream.outputstream;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//  内存写入流
public class ByteArrayOutputStreamDemo {

    @Test
    public void test() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[]{'a', 'b'};

        byteArrayOutputStream.write(97);  // 再次追加

        byteArrayOutputStream.close();  //    关闭流是不起作用的 ，这是内存流最大的特点

        byteArrayOutputStream.write(bytes, 0, bytes.length);

        int size = byteArrayOutputStream.size();  // 当前缓冲流中的字节的长度

        byteArrayOutputStream.writeTo(new FileOutputStream("src/javaSource/io/outputstream/util/wgx.txt")); // 将内存流写向某一个文件
        System.out.println("size---->" + size);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        String string = byteArrayOutputStream.toString();
        System.out.println("tostring------" + string);

        for (byte b : toByteArray) {
            System.out.println((char) b);
        }
    }
}
