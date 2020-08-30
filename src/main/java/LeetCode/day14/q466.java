package LeetCode.day14;

/**
 * @Description: https://leetcode-cn.com/problems/count-the-repetitions/ 统计重复个数
 * @author: Anhlaidh
 * @date: 2020-04-19 14:53
 */
public class q466 {
    public static void main(String[] args) {

        //acbacbacbacb
        //abab
        String s1 = "bacaba";
        int n1 = 3;
        String s2 = "abacab";
        int n2 = 1;
        System.out.println(getMaxRepetitions(s1,n1,s2,n2));

    }
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int n = 0;
        int p = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                    if (c1[j] == c2[p]) {
                        if (++p == c2.length) {
                            p = 0;
                            n++;
                        }
                    }
            }

        }
        return n / n2;
    }



}
//暴力 超时
class solution1{
        public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int point1 = 0;
        int point2 = 0;
        int current = 0;
        int index = 0;
        int count = 0;
        while (current < n1 * s1.length()) {
            if (s1.charAt(point1) == s2.charAt(point2)) {
                point2++;
                index++;
            }
            point1++;
            if (point1==s1.length()) {
                point1 = 0;
            }
            if (point2 == s2.length()) {
                if (index == s2.length() * n2) {
                    count++;
                    index = 0;
                }
                point2 = 0;
            }
            current++;

        }
        return count;
    }


}
//数学计算,解答错误(不能处理复杂情况)
class solution2{
        public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1Count = s1.length() * n1;
        int s2Count = s2.length() * n2;
        if (s2Count>s1Count) {
            return 0;
        }
        int index = 0;
        int s1Index = 0;
        int s2Index = 0;
        while (index < s1.length() && s1.charAt(s1Index) != s2.charAt(s2Index)) {
            index++;
            s1Index++;

        }
        int head = index;
        int n = 0;

        while (index <= s1Count && n != n2) {
            if (s2Index == s2.length()) {
                s2Index = 0;
                n++;
                if (n==n2) {
                    break;
                }
            }
            index++;
            char c1 = s1.charAt(s1Index);
            char c2 = s2.charAt(s2Index);
            if (c1 == c2) {
                s2Index++;

            }
            s1Index++;
            if (s1Index==s1.length()) {
                s1Index = 0;
            }



        }
        int cycle = index - head;
        int temp = index;
        while (s1.charAt(s1Index) != s2.charAt(s2Index)) {
            s1Index++;
            index++;
        }
        int mid = index - temp;


        return s1Count/(cycle+mid);



    }
}
