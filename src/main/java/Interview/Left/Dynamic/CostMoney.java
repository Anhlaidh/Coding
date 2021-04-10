package Interview.Left.Dynamic;

/**
 * @Description:
 * 从左往右尝试模
 * @author: Anhlaidh
 * @date: 2021-04-09 15:55
 */
public class CostMoney {
    public static void main(String[] args) {
        Type3.method3();
    }


    static class Type3 {
        /**
         * 有限钱数  有限张数  求目标target可能性
         * result == 15
         */
        static int target = 14;
        static int[] wallet = new int[]{1, 2, 5, 10, 20, 50, 100};
        static int[] counts = new int[]{10, 5, 2, 2, 3, 2, 1};
        private static void method3() {

            System.out.println(process(wallet,counts,0,target));
            System.out.println(dp1(wallet));

        }

        public static int process(int[] coins, int[] zhangs, int index, int rest) {
            if (index == coins.length) {
                return rest == 0 ? 1 : 0;
            }
            int ways = 0;
            for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {
                ways += process(coins, zhangs, index + 1, rest - (zhang * coins[index]));
            }
            return ways;
        }

        public static int dp1(int[] arr) {
            if (arr == null || arr.length == 0 || target < 0) {
                return 0;
            }

            int[] coins = wallet;
            int[] zhangs = counts;
            int N = coins.length;
            int[][] dp = new int[N + 1][target + 1];
            dp[N][0] = 1;
            for (int index = N - 1; index >= 0; index--) {
                for (int rest = 0; rest <= target; rest++) {
                    int ways = 0;
                    for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {
                        ways += dp[index + 1][rest - (zhang * coins[index])];
                    }
                    dp[index][rest] = ways;
                }
            }
            return dp[0][target];

        }
    }
}
