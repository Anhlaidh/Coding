package Java.test;

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
    static StringBuffer str = new StringBuffer();

    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for (int i = 0; i < nums.length; i++) {
                str.append(nums[i]);
                LockSupport.unpark(t2);

                if (i==nums.length-1) {
                    break;
                }
                LockSupport.park();
            }
        });
        t2 = new Thread(() -> {
            for (int i = 0; i < chars.length; i++) {
                str.append(chars[i]);
                LockSupport.unpark(t1);
                LockSupport.park();

            }
        });
        t1.start();
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);

    }
}
