package javaSource.nio.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Utils {

    public static byte[] getBytes(char[] chars) {//将字符转为字节(编码)
        Charset charset = Charset.forName("UTF-8");
        CharBuffer charBuffer = CharBuffer.allocate(chars.length);
        charBuffer.put(chars);
        charBuffer.flip();
        ByteBuffer byteBuffer = charset.encode(charBuffer);

        return byteBuffer.array();
    }

    public static char[] getChars(byte[] bytes) {//将字节转为字符(解码)
        Charset charset = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        CharBuffer charBuffer = charset.decode(byteBuffer);

        return charBuffer.array();
    }
}
