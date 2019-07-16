package lang.object.util;

// 用于验证 getClass() 方法
public class Person {
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
}
