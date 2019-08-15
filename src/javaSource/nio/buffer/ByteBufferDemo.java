package javaSource.nio.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class ByteBufferDemo {

    @Test
    public void testByteBufferOne() {
        //创建字节缓冲区，容量1024
        ByteBuffer buff = ByteBuffer.allocate(1024);
        System.out.println(buff.position());//读写起始点
        System.out.println(buff.limit());//界限位置
        //字节缓冲区放入3个int数值
        buff.putInt(10);
        buff.putInt(15);
        buff.putInt(20);
        System.out.println(buff.position());// 放入数据后，position:12
        //切换读取模式，方便输出数据
        buff.flip();   // 使用flip 方法是切换模式，将写模式切换成读模式
        System.out.println("切换写模式后，position———limit，" + buff.position() + "———" + buff.limit());
        //切换写入模式，方便获取数据
        buff.clear();   // 将读模式切换成写模式
        System.out.println("切换读模式后，position———limit，" + buff.position() + "———" + buff.limit());
    }

    @Test
    public void test() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        CharBuffer put = charBuffer.put("wgx");

        char[] chars = new char[600];
        CharBuffer charBuffer1 = charBuffer.get(chars, 0, 508);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        String s = String.valueOf(chars);
        System.out.println(s);

    }
}
