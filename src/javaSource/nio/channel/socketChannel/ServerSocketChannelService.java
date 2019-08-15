package javaSource.nio.channel.socketChannel;

import com.alibaba.fastjson.JSONObject;
import javaSource.nio.util.Person;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerSocketChannelService {
    private static final Integer BUFFER_SIZE = 1024;

    private static final Integer PORT = 8686;

    public static void main(String[] args) throws IOException {
        server();
    }

    /**
     * 使用java nio 实现tcp 的数据传递，需要用到charset 编解码器
     * 数据从一端传递到另外一端的时候，需要进行编码，即：encode
     * 接收到数据进行解析的时候，需要用到解码器 即：decode
     *
     * @throws IOException
     */
    public static void server() throws IOException {
        Charset charset = Charset.forName("UTF-8");
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        /**
         * accept 方法会一直阻塞
         */
        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        socketChannel.read(readBuffer);
        readBuffer.flip();
        CharBuffer decode = charset.decode(readBuffer);
        String decodeStr = new String(decode.array());
        System.out.println("接收到客户端发送的数据" + decodeStr);

        Person person = new Person("高富帅", "服务器数据");
        ByteBuffer encode = charset.encode(person.toString());
        writeBuffer.put(encode);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        socketChannel.close();
    }
}
