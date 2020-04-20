package LeetCode.day15_dyna;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-20 22:21
 */
public class q63 {
    public static void main(String[] args) {

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                    continue;
                }
                if (i == 0 & j == 0) {
                    f[i][j] = 1;
                }
                if (i > 0) {
                    f[i][j] += f[i - 1][j];
                }
                if (j > 0) {
                    f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];


    }
}
