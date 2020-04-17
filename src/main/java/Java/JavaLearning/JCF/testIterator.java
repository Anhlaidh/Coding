package Java.JavaLearning.JCF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/17 0017 0:01
 */
public class testIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

}
