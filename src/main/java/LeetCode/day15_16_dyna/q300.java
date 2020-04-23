package LeetCode.day15_16_dyna;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-20 19:31
 */
public class q300 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                10, 9, 2, 5, 3, 7, 101, 18
        };
        System.out.println(lengthOfLIS(nums));

    }
    public static int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = 1;
        int result = 1;
        for (int i = 1; i < f.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, f[j]);
                }
            }
            f[i] = temp + 1;
            result = Math.max(result, f[i]);
        }
        return result;

    }
}
