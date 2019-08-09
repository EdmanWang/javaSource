package javaSource.lang.object.util;

// 用于验证 getClass() 方法
public class Person implements Cloneable{
    private String id;

    private String name;

    public Person() {
    }

    public Person(String id) {
        this.id = id;
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void show() {

    }

    public Integer display() {
        return 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override  // 如果需要需要比较两个对象的值，则是需要重写类的equals 方法
    public boolean equals(Object obj) {
        super.equals(obj);
        Person person = (Person) obj;
        if (this.id.equals(person.id)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Person{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}
