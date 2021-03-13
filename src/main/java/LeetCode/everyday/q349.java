package LeetCode.everyday;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-11-02 10:53
 */
public class q349 {
    public static void main(String[] args) {
        int[] a = new int[]{4, 9, 5};
        int[] b = new int[]{9, 4, 9, 8, 4};
        q349 q349 = new q349();
        int[] intersection = q349.intersection(a, b);
        System.out.println(intersection);

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                continue;
            }
            if (Arrays.binarySearch(nums2, nums1[i]) >= 0) {
                set.add(nums1[i]);
            }
        }
        Object[] objects = set.toArray();
        int[] result = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {

            result[i] = (Integer) objects[i];
        }


        return result;
//         return ints
    }
}
