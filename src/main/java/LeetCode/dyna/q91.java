package LeetCode.dyna;

/**
 * @Description: https://leetcode-cn.com/problems/decode-ways/
 * @author: Anhlaidh
 * @date: 2020-04-22 15:37
 */
public class q91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));

    }
    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] f = new int[n+1];
        if (chars.length == 0) {
            return 0;
        }
        f[0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = 0;
            if (chars[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1) {
                int j = 10 * (chars[i - 2]-'0') + (chars[i - 1]-'0');
                if (j >= 10 && j <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[n];

    }
}
