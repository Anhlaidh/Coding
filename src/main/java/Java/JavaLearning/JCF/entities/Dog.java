package Java.JavaLearning.JCF.entities;

import java.util.Objects;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 16:04
 */
public class Dog {
    int size;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return size == dog.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public Dog(int size) {
        this.size = size;
    }
}
