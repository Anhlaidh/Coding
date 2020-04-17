package LeetCode.day2.q9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: isPalindrome
 * @author: Anhlaidh
 * @date: 2020/1/21 0021 14:40
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
//        String str = x+"";
//        char[] chars = str.toCharArray();
//        int j=chars.length-1;
//        for (int i=0;i<chars.length;i++){
//            if (chars[i]!=chars[j]) return false;
//            j--;
//        }
//        return true;
//    }
        int div = 1;
        int num = x;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num != 0) {
            int left = num / div;
            int right = num % 10;
            if (left != right) return false;
            num = (num - left * div) / 10;
            div /= 100;
        }
        return true;
    }
}
public class MainClass {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            boolean ret = new Solution().isPalindrome(x);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}