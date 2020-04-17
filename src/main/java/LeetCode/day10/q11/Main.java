package LeetCode.day10.q11;

/**
 * @Description:https://leetcode-cn.com/problems/container-with-most-water/
 * @author: Anhlaidh
 * @date: 2020-04-13 20:25
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
        };
        System.out.println(maxArea(a));

    }
    public static int maxArea(int[] height) {
        int index1 = 0;
        int index2;
        int maxArea = 0;
        while (index1 < height.length-1) {
            index2 = index1 + 1;
            while (index2 < height.length) {
                int current = Math.min(height[index1], height[index2]) * (index2 - index1);
                maxArea = Math.max(maxArea, current);
                index2++;
            }
            index1++;
        }
        return maxArea;

    }
}
