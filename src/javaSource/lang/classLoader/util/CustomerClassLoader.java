package javaSource.lang.classLoader.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

// 自定义的类加载器
public class CustomerClassLoader extends ClassLoader {

    private String diskUrl;  // 磁盘目录

    public CustomerClassLoader() {
    }

    public CustomerClassLoader(String diskUrl) {
        this.diskUrl = diskUrl;
    }

    @Override
    protected URL findResource(String name) {
        System.out.println("123");
        return super.findResource(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = getClassName(name);
        String myPath = "D:\\" + name + ".class";
        File file = new File(myPath);

        // 进行流操作
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int length = 0;
            while ((length = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(length);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            fileInputStream.close();
            byteArrayOutputStream.close();
            return defineClass(name, byteArray, 0, byteArray.length); // 将二进行的字节流数组转换成 class 对象,此处完成了类的加载
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private String getClassName(String name) {  // name 可能为 ---- (路经名) wgx.user.Test
        int index = name.lastIndexOf(".");  // 得出索引
        if (index == -1) {
            return name + ".class";
        } else {
            return name.substring(index + 1) + ".class";   //  组装***.class文件
        }
    }

}
