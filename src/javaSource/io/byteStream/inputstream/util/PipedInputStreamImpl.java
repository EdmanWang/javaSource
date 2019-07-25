package javaSource.io.byteStream.inputstream.util;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

// PipedInputStream单例模式
public class PipedInputStreamImpl extends PipedInputStream{

    private static PipedInputStreamImpl ipedInputStreamImpl = new PipedInputStreamImpl();

    private PipedInputStreamImpl(){

    }

    public void connectTo(PipedOutputStream pipedOutputStream) throws IOException {
        ipedInputStreamImpl.connect(pipedOutputStream);
    }

    public static PipedInputStreamImpl getInstanceOne(){
        if (ipedInputStreamImpl == null){
            ipedInputStreamImpl = new PipedInputStreamImpl();
            return ipedInputStreamImpl;
        }
        return ipedInputStreamImpl;
    }
}
