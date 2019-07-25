package javaSource.io.byteStream.inputstream.util;

import java.io.Serializable;

public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;

    private String pwd;

    public Person() {
    }

    public Person(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void display(){

    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", pwd='" + pwd + '\'' + '}';
    }
}
