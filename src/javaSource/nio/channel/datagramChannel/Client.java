package javaSource.nio.channel.datagramChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Client {

    private static final Integer BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        client();
    }

    public static void client() throws IOException {
        Charset charset = Charset.forName("UTF-8");
        DatagramChannel channel = DatagramChannel.open();
        ByteBuffer sendBuffer = ByteBuffer.allocate(BUFFER_SIZE);

        RandomAccessFile randomAccessFile = new RandomAccessFile("src/javaSource/nio/util/wgx.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        fileChannel.read(sendBuffer);
        sendBuffer.flip();

        channel.send(sendBuffer, new InetSocketAddress("127.0.0.1", 8585));
        randomAccessFile.close();
        channel.close();
    }
}
