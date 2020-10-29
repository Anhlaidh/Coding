package Interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-25 09:57
 */
public class q1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int p = reader.nextInt();
        int[] a = new int[p];
        int q = reader.nextInt();
        int[] b = new int[q];
        for (int i = 0; i < p; i++) {
            a[i] = reader.nextInt();
        }
        for (int i = 0; i < q; i++) {
            b[i] = reader.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int aCount = 0;
        int bCount = 0;
        int union = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                aCount++;
                i++;
            }
            else if (a[i] == b[j]) {
                union++;
                i++;
                j++;
            }
            else if (a[i] > b[j]) {
                bCount++;
                j++;
            }
        }
        aCount += a.length - i;
        bCount += b.length - j;
        System.out.println(aCount+" "+bCount+" "+union);
    }
}
