package Java.JavaLearning_Advanced.thread.mashibing.A1B2C3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-20 19:01
 */
public class aAbBcC {
    static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    static char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static CountDownLatch latch1 = new CountDownLatch(1);
    static StringBuffer str = new StringBuffer();

    public static void main(String[] args) {


    }
}
