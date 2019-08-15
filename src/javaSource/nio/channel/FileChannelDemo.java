package javaSource.nio.channel;

import org.junit.Test;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class FileChannelDemo {

    @Test
    public void testRandomAccessFile() throws IOException {
        /**
         *  0：FileChannel是一个抽象类，需要他的实现类去常见文件Channel
         *  1：FileChannelImpl 不能实例化出来对象，它是一个私有地构造函数
         *  FileChannel channel = new FileChannelImpl(new FileDescriptor(),"123",true,true,true,"2");
         */
        RandomAccessFile rwFile = new RandomAccessFile("src/javaSource/nio/util/wgx.txt", "rw");
        FileChannel channel = rwFile.getChannel();
        System.out.println("channel is " + channel);  //sun.nio.ch.FileChannelImpl@5ce65a89 是FileChannelImpl的一个对象
        FileDescriptor fd = rwFile.getFD();
        System.out.println("FileDescriptor is" + fd.valid());

        /**
         * 复习 read and write
         */
        byte[] byteRead = new byte[20];
        int read = rwFile.read(); // 读一个字节
        int readBytes = rwFile.read(byteRead); // 读一个字节数组
        int read1 = rwFile.read(byteRead, 0, byteRead.length); // 数据存放在字节数组里面

        byte[] byteWrite = new byte[]{'a', 'b'};
        rwFile.write(100);
        rwFile.write(byteWrite); // 将字节数组中的数据写入文件
        rwFile.write(byteWrite, 0, 1);

        String s = rwFile.readLine();

        System.out.println(s + s);

        byte b = rwFile.readByte();
        char c = rwFile.readChar();
        System.out.println(b + c);
        int i = rwFile.readInt();
    }

    @Test
    public void testLock() throws IOException {
        RandomAccessFile rwFile = new RandomAccessFile("src/javaSource/nio/util/wgx.txt", "rw");
        FileChannel channel = rwFile.getChannel();
        //FileLock lock = channel.lock(); // 一个channel 就是一个流。将channel锁住以后，就是保证只有一个线程拥有该资源

        //FileLock fileLock = channel.tryLock();
//        FileLock lock = channel.lock(0, 1024, false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int read = channel.read(byteBuffer);// 将数据读取到buffer中
    }

    @Test
    public void testReadAndWrite() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/javaSource/nio/util/wgx.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        byte[] bytes = "abc".getBytes();
        byteBuffer.put(bytes);
        byteBuffer.flip();
        int write = channel.write(byteBuffer);
        ByteBuffer allocate = ByteBuffer.allocate(10);
        int read = channel.read(allocate, 0);
        byte b = allocate.get(2);
        System.out.println(b);
    }

    @Test
    public void testWrite() throws IOException {
        File file = new File("src/javaSource/nio/util/wgx.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel channel = randomAccessFile.getChannel();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        // 使用默认的编码器
        CharsetEncoder charsetEncoder = Charset.defaultCharset().newEncoder();

        /**
         * buffer 有三个重要的字段
         * 1：position   指的是当前缓冲块中的存放的位置
         * 2：limit
         * 3: capacity 容量  这个字段一般是不会变的
         */
        charBuffer.put("wgx12345王国雄");
        System.out.println(charBuffer.position()+"---"+charBuffer.limit()+"------"+charBuffer.capacity());
        charBuffer.flip(); // 源码写的很清楚
        System.out.println(charBuffer.position()+"---"+charBuffer.limit()+"------"+charBuffer.capacity());
        charBuffer.clear(); // 源码写的很清楚
        System.out.println(charBuffer.position()+"---"+charBuffer.limit()+"------"+charBuffer.capacity());

        // 将数据进行编码
        ByteBuffer buffer = charsetEncoder.encode(charBuffer);
        channel.write(buffer); // 将数据从缓冲区中写入到channel

        channel.close();
        randomAccessFile.close();
    }

    @Test
    public void testRead() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/javaSource/nio/util/wgx.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();

        while (channel.read(byteBuffer) != -1) { // 数据得确实读到的缓冲区中去了 ，即： 是数据块
            byteBuffer.flip(); // 将数据重缓冲流中刷出来，确定七点位置和终点位置
            CharBuffer decode = decoder.decode(byteBuffer); // 进行编码是
            System.out.println(decode.toString()); // 输出数据
            //清空缓冲区，再次放入数据
            byteBuffer.clear();
        }
    }
}
