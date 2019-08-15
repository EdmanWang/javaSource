package javaSource.nio.channel.datagramChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class Server {
    private static final Integer BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        server();
    }

    public static void server() throws IOException {
        DatagramChannel server = DatagramChannel.open();
        Charset charset = Charset.forName("UTF-8");
        server.bind(new InetSocketAddress(8585));

        ByteBuffer recive = ByteBuffer.allocate(BUFFER_SIZE);

       while (true){
           server.receive(recive);
           recive.flip();

           CharBuffer charBuffer = charset.decode(recive);
           String str = new String(charBuffer.array());
           System.out.println(str);
       }
    }
}
