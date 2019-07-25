package javaSource.io.byteStream.outputstream.filterOutputStream;

// BufferedOutputStream 测试demo
// 写入缓冲流

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {

    @Test
    public void test() throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("src/javaSource/io/outputstream/util/wgx.txt"),true));
        bufferedOutputStream.write('a');
        bufferedOutputStream.write('a');

        bufferedOutputStream.close();
        bufferedOutputStream.write('a');  // 关闭流以后不会报错，flush操作将缓存数据全部刷新大磁盘，所以这句话不起作用
    }
}
