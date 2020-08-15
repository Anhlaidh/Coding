package LeetCode.day17;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-13 00:04
 */
public class day17 {
    public static void main(String[] args) {
        String[] strs = new String[]{"aca","cba"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));

    }
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length==0) return "";
            int shortest = Integer.MAX_VALUE;
            for (String s : strs) {
                shortest = Math.min(s.length(), shortest);
            }
            //找到最短字符串长度,逆向遍历
            int index = shortest-1;
            char temp = ' ';
            int length = 0;
            while (index >= 0) {
                temp = strs[0].charAt(index);
                length++;
                for (String s : strs) {
                    if (temp != s.charAt(index)) {
                        length = 0;
                        break;
                    }
                }
                index--;
            }
            return strs[0].substring(0, length);
        }
    }
}
