### 关于java源码中class类的相关分析总结

**java的类加载机制**

    1：对于我们日常创建的任何一个类（person,user....），编译器在启动的时候会帮我们自动编译成二进制文件，即使xxxx.class文件。会保留在指定的
       磁盘上，java虚拟机在运行的时候，类加载器（classLoader）会将指定（遇到的 new 关键字）的class文件（通过类的权限定名）加载到内存中，并返回
       一个Class 对象。