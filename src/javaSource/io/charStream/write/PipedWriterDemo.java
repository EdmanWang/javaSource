package javaSource.io.charStream.write;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

// 字符管道写入流
public class PipedWriterDemo {

    @Test
    public void test() throws IOException {
        // 需要和一个字符管道读出流相连接
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        pipedWriter.connect(pipedReader);

//        pipedReader.connect(pipedWriter);  只是需要连接一次，不管是输入连接输出，还是输出连接输入

    }
}
