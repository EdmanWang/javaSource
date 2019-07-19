### 关于java源码中class类的相关分析总结

**java的类加载机制**

    1：对于我们日常创建的任何一个类（person,user....），编译器在启动的时候会帮我们将源码文件自动编译成二进制文件，即使xxxx.class文件。
       并且保留在指定的磁盘上。
       
    2：java虚拟机在启动的时候，会通过bootstrpClassLoader和extentionClassLoader,加载一些对应文件夹下的jar包。
    
    3：程序在运行的时候，会动态加载类。比如，遇到new一个对象，或者遇到反射的时候。。。。。会通过类加载器加载该类
**双亲委派原则**
    直接上连接[java中的ClassLoader详解](https://blog.csdn.net/qq_31493821/article/details/78812057) 