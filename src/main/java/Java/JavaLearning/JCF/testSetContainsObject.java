package Java.JavaLearning.JCF;

import Java.JavaLearning.JCF.entities.Dog;
import Java.JavaLearning.JCF.entities.Tiger;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 16:04
 */
public class testSetContainsObject {
    public static void main(String[] args) {
        HashSet<Dog> hs = new HashSet<>();
        LinkedHashSet ls = new LinkedHashSet();
        TreeSet ts = new TreeSet();
        //add dog;
        hs.add(new Dog(3));
        hs.add(new Dog(3));
        hs.add(new Dog(4));
        hs.add(new Dog(5));

        ls.add(new Dog(3));
        ls.add(new Dog(3));
        ls.add(new Dog(4));
        ls.add(new Dog(5));

        ts.add(new Tiger(3));
        ts.add(new Tiger(3));//需要又Comparable接口，才可以添加
        ts.add(new Tiger(4));
        ts.add(new Tiger(5));

        System.out.println("HashSet:"+hs.size());
        System.out.println("LinkedHashSet:"+ls.size());
        System.out.println("TreeSet:"+ts.size());

    }
}
