package SwordFingerOffer;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 09:35
 */
public class NumberOf1 {
    public static void main(String[] args) {
        int n = -1000000;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("            "+Integer.toBinaryString(-n));
        System.out.println(NumberOf1(n));

    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);

        }
        return count;



    }
}
