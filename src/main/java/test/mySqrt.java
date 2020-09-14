package test;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-13 16:26
 */
public class mySqrt {
    static void test() {
        Random random = new Random();
        int[] ints = random.ints(100000, 0, 100000).toArray();
        for (int i = 0; i < ints.length; i++) {
            if ((int) Math.sqrt(ints[i]) != mySqrt(ints[i])) {
                System.out.println(ints[i]);
                System.out.println("normal:" + (int)Math.sqrt(ints[i]));
                System.out.println("my:" + mySqrt(ints[i]));
                System.out.println("------------------------");
            }
        }
    }
    public static void main(String[] args) {
        test();
//        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        int right = x;
        int left = 0;
        int mid = (right + left) / 2;
        if (mid == 0) {
            if (x<1) return 0;
            return 1;
        }
        while (!(mid <= x / mid && (mid + 1) > x/(mid + 1))) {
            if ((mid+1)== x/(mid+1)) return mid + 1;
            if (mid <= x / mid) {
                left = mid + 1;

            }
            if ((mid + 1) > x/(mid + 1)) {
                right = mid-1;
            }
            mid = (right + left) / 2;
        }
        return mid;

    }
}
