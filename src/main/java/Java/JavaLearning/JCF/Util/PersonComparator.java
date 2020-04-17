package Java.JavaLearning.JCF.Util;

import java.util.Comparator;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 23:09
 */
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person person, Person t1) {
        return person.getAge()-t1.getAge();
    }
}
