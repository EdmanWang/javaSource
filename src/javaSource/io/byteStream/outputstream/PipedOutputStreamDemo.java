package javaSource.io.byteStream.outputstream;

import javaSource.io.byteStream.inputstream.util.PipedInputStreamImpl;
import javaSource.io.byteStream.outputstream.util.PipedOutputStreamImpl;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流输出流对象
 * 1：需要一个管道进行联通，即：一个写线程和一个读线程
 */
public class PipedOutputStreamDemo {

    @Test
    public void testWrite() throws IOException {
        PipedInputStream pipedInputStream = PipedInputStreamImpl.getInstanceOne();

        PipedOutputStreamImpl pipedOutputStream = PipedOutputStreamImpl.getInstanceTwo();

        pipedOutputStream.connectTo(pipedInputStream);
        byte[] bytes = new byte[]{'a', 'b'};
        pipedOutputStream.write(bytes, 0, bytes.length);
    }
}
