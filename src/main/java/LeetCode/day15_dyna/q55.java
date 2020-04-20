package LeetCode.day15_dyna;

/**
 * @Description: 跳跃游戏 https://leetcode-cn.com/problems/jump-game/
 * @author: Anhlaidh
 * @date: 2020-04-20 16:51
 */
public class q55 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 3, 1, 1, 4
        };
        System.out.println(canJump(nums));

    }
    public static boolean canJump(int[] nums) {
        boolean[] f = new boolean[nums.length];
        f[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (f[i]) {
                for (int j = 0; j <= nums[i]; j++) {
                    if (i + j < nums.length) {
                        f[j + i] = true;
                    }
                }
            }
        }
        return f[nums.length-1];


    }
}
