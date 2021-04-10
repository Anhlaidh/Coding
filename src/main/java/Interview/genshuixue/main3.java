package Interview.genshuixue;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-04-09 10:18
 */
public class main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int[][] arr = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            int[] cur_re = new int[N];
            for (int j = N - 1; j >= 0; j--) {
                cur_re[j] = reader.nextInt();
            }
            arr[i] = cur_re;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
