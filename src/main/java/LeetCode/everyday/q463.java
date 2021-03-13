package LeetCode.everyday;

import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-30 19:49
 */
public class q463 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
//        int[][] arr = new int[][]{{1}};
//        int[][] arr = new int[][]{{0}, {1}};
        System.out.println(islandPerimeter(arr));

    }

    public static int islandPerimeter(int[][] grid) {
        int sum = 0;
        int[][] fix = new int[grid.length + 2][];
        int p = 0;
        for (int i = 0; i < fix.length; i++) {
            fix[i] = new int[grid[0].length + 2];
            if (i == 0 || i == fix.length - 1) {
                continue;
            }
            if (p < grid.length) {
                System.arraycopy(grid[p], 0, fix[i], 1, grid[p].length);
                p++;
            }
        }
        for (int i = 0; i < fix.length; i++) {
            for (int j = 0; j < fix[i].length; j++) {
                if (fix[i][j] == 1) {
                    continue;
                } else {
                    sum += getNear(fix, i, j);
                }

            }
        }
        return sum;
    }

    private static int getNear(int[][] fix, int i, int j) {
        int result = 0;
        if (i<fix.length-1&&fix[i + 1][j]==1) {
            result++;
        }
        if (i>1&&fix[i - 1][j] == 1) {
            result++;

        }
        if (j<fix[i].length-1&&fix[i][j + 1] == 1) {
            result++;

        }
        if (j>1&&fix[i][j - 1] == 1) {
            result++;

        }
        return result;
    }
}
