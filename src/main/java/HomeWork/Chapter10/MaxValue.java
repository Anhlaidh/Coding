package HomeWork.Chapter10;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-29 15:23
 */
public class MaxValue {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = random.ints(10, -100, 100).toArray();
        arr = new int[]{-2, 11, -4, 13, -5, -2};
        System.out.println(solution(arr));

    }

    public static int solution(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i] = arr[i];
                continue;
            }
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

        }
        return dp[dp.length - 1];

    }
}
