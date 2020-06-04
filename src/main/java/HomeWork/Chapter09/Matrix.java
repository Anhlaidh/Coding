package HomeWork.Chapter09;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-15 16:13
 */

public class Matrix {
    public static void main(String[] args) {
        int[] arr = {3, 5, 10, 8, 2, 4};
        System.out.println(solution(arr));

    }

    static int solution(int[] input) {
        int[][] dp = new int[input.length - 1][input.length - 1];
        int p = 0;
        while (p <dp.length) {
            for (int i = 0; i <dp.length; i++) {
                for (int j = i; (j <= i + p) && j < dp.length; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    if (i == j) {
                        dp[i][j] = 0;
                        continue;
                    }
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + input[i] * input[k+1] * input[j+1], dp[i][j]);
                    }
                }
            }
            p++;

        }
        return dp[0][input.length-2];
    }
}
