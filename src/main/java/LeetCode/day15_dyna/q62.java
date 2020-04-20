package LeetCode.day15_dyna;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-20 16:27
 */
public class q62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));

    }

    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        f[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];

            }
        }
        return f[m - 1][n - 1];

    }
}
