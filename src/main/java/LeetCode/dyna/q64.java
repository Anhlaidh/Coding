package LeetCode.dyna;

/**
 * @Description:https://leetcode-cn.com/problems/minimum-path-sum/
 * @author: Anhlaidh
 * @date: 2020-04-23 20:24
 */
public class q64 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 5},
                {3, 2, 1}
        };
        (new q64()).minPathSum(grid);

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
        if (n == 0) {
            return 0;
        }
        int old, now = 0;
        for (int i = 0; i < m; i++) {
            //swap old and now
            old = now;
            now = 1 - old;
            for (int j = 0; j < n; j++) {
                dp[now][j] = grid[i][j];
                if (i == 0 && j == 0) {
                    continue;
                }

                int t = Integer.MAX_VALUE;
                if (i > 0) {
                    t = Math.min(t, dp[old][j]);

                }
                if (j > 0) {
                    t = Math.min(t, dp[now][j-1]);

                }
                dp[now][j] += t;
            }

        }
        return dp[now][n - 1];

    }
}
