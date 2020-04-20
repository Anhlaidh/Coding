package LeetCode.day15_dyna;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-20 19:10
 */
public class q279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));

    }
    public static int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i - j * j] + 1, f[i]);
            }
        }
        return f[n];
    }
}
