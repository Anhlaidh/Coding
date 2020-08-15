package Java.Java_Final.Lambda;

import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-06 22:26
 */
public class method {
    public static void main(String[] args) {
//        double a = -3.5;
//        double b = worker(Math::abs, a);
//        System.out.println(b);
//        double c = worker(Math::floor, a);
//        System.out.println(c);
//        double d = worker((num -> (num % 10)), a);
//        System.out.println(d);
        worker1();
    }

    public static double worker(NumFunction nf, double num) {
        return nf.calculate(num);
    }

    static void worker1() {
        String[] planets = new String[]{"DDD","aaa", "bbb", "ccc"};
        Arrays.sort(planets, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(planets));
    }
}
