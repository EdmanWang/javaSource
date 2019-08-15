package javaSource.nio.channel.socketChannel;

import javaSource.nio.util.Person;
import javaSource.nio.util.Utils;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelClient {

    private static final Integer BUFFER_SIZE = 1024;

    private static final Integer PORT = 8686;

    @Test
    public void test() throws IOException {
        SocketChannel channel = SocketChannel.open();
        boolean localhost = channel.connect(new InetSocketAddress("localhost", 1234));
        if (localhost) {
            // client.write() 向通道写入数据
            // channel.read() 从通道中读出数据
        }
    }

    public static void main(String[] args) throws IOException {
        client();
    }

    public static void client() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/javaSource/nio/util/wgx.txt"))));
        Person person = new Person("wgx", "王国雄");
        Charset charset = Charset.forName("UTF-8");
        SocketChannel socketChannel = SocketChannel.open();
        boolean connect = socketChannel.connect(new InetSocketAddress("127.0.0.1", PORT));
        if (connect) {
            System.out.println("客户端与服务器端连接成功");
            /**
             * 对于nio 的缓冲块来说，可以做到复用
             */
//            ByteBuffer bufferWrite = ByteBuffer.allocate(BUFFER_SIZE);
//            ByteBuffer bufferRead = ByteBuffer.allocate(BUFFER_SIZE);
            ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
            // 对数据源进行编码
            ByteBuffer encode = charset.encode(person.toString());
            // 将编码数据放入缓冲块
            byteBuffer.put(encode);
            byteBuffer.flip();
            // 将数据块中的数据线读出来，再写入通道   write 需要反方向看这一行代码
            socketChannel.write(byteBuffer);

            byteBuffer.clear();

            socketChannel.read(byteBuffer);  // read 需要反方向看这一行代码
            byteBuffer.flip();
            CharBuffer decode = charset.decode(byteBuffer);
            char[] array = decode.array();
            String str = new String(array);
            System.out.println("接收到服务器端的数据是" + str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("src/javaSource/nio/util/wgx.txt"));
            byte[] bytes = Utils.getBytes(array);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }
        socketChannel.close();
    }
}
