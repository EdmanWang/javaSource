package javaSource.io.byteStream.inputstream;

import javaSource.io.byteStream.inputstream.util.PipedInputStreamImpl;
import javaSource.io.outputstream.util.PipedOutputStreamImpl;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 管道流输出流对象
 * 1：需要一个管道进行联通，即：一个写线程和一个读线程
 * 2；使用单例模式
 */
public class PipedInputStreamDemo {

    @Test
    public void test() throws IOException {
        PipedInputStreamImpl pipedInputStream = PipedInputStreamImpl.getInstanceOne();
        PipedOutputStreamImpl pipedOutputStream = PipedOutputStreamImpl.getInstanceTwo();

        pipedInputStream.connectTo(pipedOutputStream);

        int read = pipedInputStream.read();
        System.out.println("read one byte --->" + read);
    }
}
