package javaSource.collection.util;

public class Person {
    private String name;

    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {  // 重写equals方法
        Person person = (Person) obj;
        if (person.getAge() == this.getAge()) {
            return true;
        }
        return super.equals(obj); // 父类的equals是比较hash值
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

}
