package HomeWork.Chapter10;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-06-04 13:40
 */
public class LCS {
    public static void main(String[] args) {
        char[] A = {'a', 'b', 'c', 'b', 'd'};
        char[] B = {'b', 'd', 'c', 'a', 'b'};
        System.out.println(solution(A, B));
    }

    private static int solution(char[] a, char[] b) {
        int[][] dp = new int[a.length+1][b.length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                }
                if (a[i-1] != b[j-1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }
}