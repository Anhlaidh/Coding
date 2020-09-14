package Java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 15:05
 */
public class PS {
    static List<Integer> nums = new ArrayList<>();
    static {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            nums.add(100000 + random.nextInt(100000));
        }
    }
    public static void foreach() {
        nums.forEach(v -> isPrime(v));
    }
    public static void parallel(){
        nums.parallelStream().forEach(PS::isPrime);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }
}
