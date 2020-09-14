package SwordFingerOffer;

import java.util.Random;
import java.util.TreeSet;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-02 17:33
 */
public class Add {
    static void test() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int[] num1 = random.ints(100, Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();
            int[] num2 = random.ints(100, Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();
            for (int j = 0; j < num1.length; j++) {
                if (normal(num1[j], num2[j]) != Add(num1[j], num2[j])) {
                    System.out.println(num1[j] + "  " + num2[j]);
                }
            }
        }

    }

    public static void main(String[] args) {
        int num1 = 83;
        int num2 = 102;
        System.out.println(normal(num1, num2));
        System.out.println(Add(num1, num2));

    }

    public static int normal(int num1, int num2) {
        return num1 + num2;
    }
    public static int Add(int num1,int num2) {
        return num1| num2;
    }

}
