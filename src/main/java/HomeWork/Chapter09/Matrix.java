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
//        for (int i = 0; i < dp.length; i++) {
//            int p = i;
//            for (int j = p; (j <= p+1)&&j<dp.length; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//                if (i == j) {
//                    dp[i][j] = 0;
//                    continue;
//                }
//
//                for (int k = i; k < j; k++) {
//                    int temp = dp[i][k] + dp[k + 1][j] + input[i] * input[k + 1] * input[j + 1];
//                    dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + input[i] * input[k+1] * input[j+1], dp[i][j]);
//
//                }
//            }
//            p++;
//        }
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
                        int temp = dp[i][k] + dp[k + 1][j] + input[i] * input[k + 1] * input[j + 1];
                        dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + input[i] * input[k+1] * input[j+1], dp[i][j]);
                    }
                }
            }
            p++;

        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"\t\t\t");
            }
            System.out.println();
        }
        return dp[input.length-2][input.length-2];
    }
}
