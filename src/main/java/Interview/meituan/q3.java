package Interview.meituan;

import java.util.Scanner;

/**
 * @Description:  X & (2^N - 1)
 * @author: Anhlaidh
 * @date: 2020-10-25 10:23
 */
public class q3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }
        //从1-n
        for (int i = 1; i <= b.length; i++) {
            int mod[] = new int[n];
            for (int j = 1; j <= n; j++) {

                mod[j-1] = i % j;
            }
            for (int j = 0; j < mod.length; j++) {
                mod[0] = mod[0] ^ mod[j];
            }
            b[i-1] = a[i - 1] ^ mod[0];
        }
        for (int i = 1; i < b.length; i++) {
            b[0] = b[0] ^ b[i];
        }
        System.out.println(b[0]);

    }
}
