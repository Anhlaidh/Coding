package LeetCode.day1.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/1/20 0020 16:32
 */
public class lengthOfLongestSubstring {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().lengthOfLongestSubstring(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //双指针移动
        //boolean数组判断ASCII码是否已出现过
        boolean[] used = new boolean[128];
        int left=0;
        int right=0;
        int MAX=0;
        while (right<s.length()){

            while (right<s.length()&&!used[s.charAt(right)]){//判断语句的先后顺序很重要！！！

                used[s.charAt(right)]=true;

                right++;
                MAX=Math.max(MAX,right-left);

            }
            used[s.charAt(left)]=false;
            left++;
        }

        return MAX;
    }
}
