package Interview.tencent.s;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-06 20:26
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        int[] help = Arrays.copyOfRange(arr, 0, arr.length);
        //排序
        Arrays.sort(help);
        int mid1 = help[n / 2 - 1];
        int mid2 = help[n / 2];
        for (int i = 0; i < n ; i++) {
            if (arr[i] < mid2) {
                System.out.println(mid2);
            } else System.out.println(mid1);
        }
    }
}
