package exam.exam5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-29 15:59
 */
public class q1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        for (int i = 0; i < N; i++) {
            int[] arr = new int[reader.nextInt()];
            int mans = reader.nextInt();
            for (int j = 0; j < arr.length;j++) {
                arr[j] = reader.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(solution(arr,mans));
        }
    }

    private static int solution(int[] arr, int mans) {
        if (mans<=0) {
            return 0;
        }

        int most = arr.length - 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int result = 0;
        if (arr.length >= mans) {
            return arr[0];
        } else {
            if (arr[most] < mans) {
                return 1;
            } else {
                return arr[most] % mans;
            }
        }


    }
}
