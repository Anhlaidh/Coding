package Java.Java_Final.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-07 15:06
 */
public class testIterable<T> {
    public static void main(String[] args) {
        String[] p = new String[]{"aaa", "bbb", "ccc"};
        ArrayList<String> pList = new ArrayList<String>(Arrays.asList(p));
        for (String s : pList) {
            System.out.println(s);
        }
        pList.forEach(System.out::println);
        System.out.println("===");
        HashMap<String, Integer> counter = new HashMap<>();
        for (String s : pList) {
            counter.merge(s, 1, (count, incr) -> count + incr);
            counter.merge(s, 1, Integer::sum);
        }
        Integer test = test(Math::abs, 1);
        System.out.println(test);
        parsInt(Integer::parseInt, "aaa");

    }

    static Integer test(Function<Integer, Integer> fun, Integer num) {
        return fun.apply(num);
    }

    static Integer parsInt(Function<String , Integer> function, String a) {
        return function.apply(a);
    }
}
