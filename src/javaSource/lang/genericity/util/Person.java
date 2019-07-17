package javaSource.lang.genericity.util;

// 自定义泛型类
public class Person<T1, T2> {
    T1 tl;
    T2 t2;

    public T1 getTl() {
        return tl;
    }

    public void setTl(T1 tl) {
        this.tl = tl;
    }

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }

    // 自定义泛型方法
    public <T1, T2> void display(T1 x, T2 y) {
        T1 m = x;
        T2 n = y;
        System.out.println("test----" + m);
        System.out.println("test----" + n.getClass().getName());
    }

    @Override
    public String toString() {
        return "Person{" + "tl=" + tl + ", t2=" + t2 + '}';
    }
}
