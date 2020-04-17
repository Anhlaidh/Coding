package Interview;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-12 18:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        boolean[] result = new boolean[N];
        while (N-- > 0) {
            int size = reader.nextInt();
            //创建数组
            int[] a = new int[size];
            int[] b = new int[size];
            for (int i = 0; i < size; i++) {
                a[i] = reader.nextInt();
            }
            for (int i = 0; i < size; i++) {
                b[i] = reader.nextInt();
            }
            boolean solution = solution(a, b);
            result[N] = solution;

        }
        for (int i = result.length-1; i >=0; i--) {
            if (result[i]) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    private static boolean solution(int[] a, int[] b) {
        int index1 = 0;
        int index2 = 0;
        int range = 0;
        while (index1 < a.length) {
            if (a[index1] == b[index2]) {
                index1++;
                index2++;
            }else break;
        }
        if (index1 == a.length) {
            return true;
        } else {
            range = a[index1] - b[index2];
        }
        while (index1 < a.length) {
            if (a[index1] == b[index2]) {
                range = 0;
                index1++;
                index2++;
                continue;
            }
            if (a[index1] - b[index2] != range) {
                return false;
            }
            else {
                index1++;
                index2++;
            }
        }
         return true;
    }
}

