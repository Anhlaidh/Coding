package Java.JavaLearning.JCF.Util;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 23:08
 */
public class Person {
    int age;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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
}
