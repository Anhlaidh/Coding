package test.blubridge;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-16 19:22
 */
public class sumEight {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        long start = System.currentTimeMillis();
        method1(n);
        long end = System.currentTimeMillis();
        long l = end - start;
        System.out.println("====="+ l +"=====");
    }

    private static void method1(int n) {
        int mod = 123456789;
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            long temp = i;
            for (int j = 0; j < 3; j++) {
                temp = temp % mod;
                temp = (temp * temp)    ;
            }
            sum = (sum%mod+temp%mod)%mod;
        }
        System.out.println(sum);
    }
}
