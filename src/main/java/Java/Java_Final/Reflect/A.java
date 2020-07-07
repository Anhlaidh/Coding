package Java.Java_Final.Reflect;

import java.io.Serializable;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-07 19:58
 */
class A implements Serializable {
    public int age;
    private String name;

    public A(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public A() {
    }

    private static final long serialVersionUID = 1L;

    public void hello() {
        System.out.println("hello from A");

    }

    public void print() {
        System.out.println(name + ":" + age);
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getString(String string) {
        return string;
    }

}

class B extends A implements Runnable{

    @Override
    public void run() {

    }
}