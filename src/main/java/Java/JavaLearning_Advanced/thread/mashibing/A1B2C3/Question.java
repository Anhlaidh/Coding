package Java.JavaLearning_Advanced.thread.mashibing.A1B2C3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description: 两个线程,顺序打印A-Z,1-26,要求交叉打印
 * @author: Anhlaidh
 * @date: 2020-08-18 13:09
 */
public class Question {
    static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    static char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static StringBuffer str = new StringBuffer();
    static CountDownLatch latch = new CountDownLatch(nums.length + chars.length);

    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for (int i = 0; i < nums.length; i++) {
                LockSupport.park();
                str.append(nums[i]);
                latch.countDown();
                LockSupport.unpark(t2);
            }
        });
        t2 = new Thread(() -> {
            LockSupport.unpark(t1);
            for (int i = 0; i < chars.length; i++) {
                LockSupport.park();
                str.append(chars[i]+ " ");
                latch.countDown();
                LockSupport.unpark(t1);

            }
        });
        t1.start();
        t2.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);

    }

}
