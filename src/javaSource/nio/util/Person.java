package javaSource.nio.util;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    private String desc;

    public Person(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", desc='" + desc + '\'' + '}';
    }
}
