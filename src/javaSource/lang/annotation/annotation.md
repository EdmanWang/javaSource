 ### 注解相关总结
 
 **解释一下java源码包中的几个关键类**
  
  1：Annotation 是全部注解类的基类
  
  2：Documented 是一个注解其他注解的注解，它的作用是能够将注解中的元素包含到 Javadoc 中去
  
  3：ElementType 是一个枚举类，用于定义注解的类型，或者说注解作用的地方。
  
  4：Inherited 是一个注解，用于注解其他的注解，它表示会继承父类的全部注解。
  
  5：Native 只对属性有效，且只在代码中使用，一般用于给IDE工具做提示用。
  
  6：Repeatable 是一个注解，用于注解其他的注解，它表示可以多次注入数据。
  
  7：Retention 是一个注解，用于注解其他的注解，它表示注解的生命周期或者说注解合适会被丢弃。
  
  8：RetentionPolicy 是一个枚举类，用于注解的生命周期。
  
  9：Target 是一个注解，用于注解其他的注解，它表示注解的类型。
  
  直接给链接  [Java注解深入浅出](https://blog.csdn.net/shengzhu1/article/details/81271409) 此链接上面有很详细的说明