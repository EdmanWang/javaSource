package javaSource.io.byteStream.outputstream.util;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

// PipedOutputStream单例模式
public class PipedOutputStreamImpl extends PipedOutputStream {

    private static PipedOutputStreamImpl PipedOutputStreamImpl = new PipedOutputStreamImpl();

    private PipedOutputStreamImpl(){

    }

    public void connectTo(PipedInputStream pipedInputStream) throws IOException {
        PipedOutputStreamImpl.connect(pipedInputStream);
    }

    // 懒汉模式
    public static PipedOutputStreamImpl getInstanceTwo() {
        if (PipedOutputStreamImpl == null){
            PipedOutputStreamImpl = new PipedOutputStreamImpl();
            return PipedOutputStreamImpl;
        }
        return PipedOutputStreamImpl;
    }
}
