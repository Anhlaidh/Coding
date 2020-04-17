package Java.JavaLearning.JCF.Util;

import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 23:08
 */
public class testSort {
    public static void main(String[] args) {
        Person[] people = new Person[3];
         people[0]= new Person(15, "A");
         people[1]= new Person(20, "B");
         people[2]= new Person(11, "C");
         Arrays.sort(people,new PersonComparator());
        for (Person person : people) {
            System.out.println(person);
        }



    }
}
