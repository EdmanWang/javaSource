package javaSource.io.charStream.write;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 测试bufferWrite demo 实现
public class BufferedWriterDemo {

    @Test
    public void testWrite() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/javaSource/io/charStream/write/util/wgx.txt"))), 1);
        bufferedWriter.write(97);
        bufferedWriter.write(98);
        //bufferedWriter.flush();   // bufferWrite 是需要将写入的数据刷新到文件中去，不然的话，数据是不会从缓冲中出去

        //bufferedWriter.write("王国雄"); // 数据从缓冲中刷入到文件对象后，再次写入数据是无效的

        bufferedWriter.newLine();  // 换行
        bufferedWriter.write("王国雄");
        // bufferedWriter.write(); 对象灰色的方法指的是父类的方法
//        bufferedWriter.flush();
        bufferedWriter.close(); // 关闭流的时候，会将数据刷过去。
    }
}
