package LeetCode.day1.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TwoSum {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new Solution().twoSum(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
//        //遍历数组 时间复杂度O(n²),空间复杂度O(1)
//        for (int i=0;i<nums.length;i++){
//            for (int j=i+1;j<nums.length;j++){
//                if (nums[i]+nums[j]==target){
//                    res[0]=i;
//                    res[1]=j;
//                }
//            }
//        }
        if (nums==null||nums.length<=1) return res;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        //一个key对应一个value，一个value可对应多个key，所以序号作为value，值作为key
        for (int i =0;i<nums.length;i++){
            int num = nums[i];
            int val = target-num;
            if (map.containsKey(val)){
                res[0]=i;
                res[1]=map.get(val);
                return res;
            }
            else map.put(num,i);
        }


        return res;
    }
}