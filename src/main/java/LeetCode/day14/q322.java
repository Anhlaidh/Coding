package LeetCode.day14;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-19 21:58
 */
public class q322 {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int M = amount + 1;
        int[] f = new int[M];
        f[0] = 0;
        for (int i = 1; i < M; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0 && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }
}

