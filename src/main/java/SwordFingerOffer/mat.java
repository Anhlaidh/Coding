package SwordFingerOffer;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-12 01:23
 */
public class mat {
    public static void main(String[] args) {
        char[] str = "".toCharArray();
        char[] pattern = ".".toCharArray();
        System.out.println(match(str, pattern));
    }
    public static boolean match(char[] str, char[] pattern) {
        if (pattern.length==2&&pattern[0]=='.'&&pattern[1]=='*' ) {
            return true;
        }
        int i = 0;
        int j = 0;

       return matchStr(str, pattern, i, j);
    }

    /**
     *  返回是否匹配
     * @param str 字符串
     * @param pattern 模式
     * @param index1 字符串当前坐标
     * @param index2 模式当前坐标
     */
    private static boolean matchStr(char[] str, char[] pattern, int index1, int index2) {
        //终止递归条件1
        if (index1 == str.length && (index2 == pattern.length || (index2 == pattern.length - 1 && pattern[index2] == '*'))) {
            return true;
        }
        //终止递归条件2
        if (index1 == str.length || pattern.length == index2) {
            if (index1 == str.length) {
                while (index2 < pattern.length) {
                    if (index2 + 1 < pattern.length && pattern[index2 + 1] == '*') {
                        index2 += 2;
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        //当pattern的下一个字符为*时
        if (index2 < pattern.length - 1 && pattern[index2 + 1] == '*') {
            if (judge(str[index1], pattern[index2])) {
                return matchStr(str, pattern, index1, index2 + 2) || matchStr(str, pattern, index1 + 1, index2);
            } else {
                return matchStr(str, pattern, index1, index2 + 2);
            }
        }
        //当前两个下表所指的字符匹配
        if (judge(str[index1], pattern[index2])) {
            return matchStr(str, pattern, index1 + 1, index2 + 1);
        }
        return false;
    }
    private static boolean judge(char a, char b) {
        if (a == b || b == '.') {
            return true;
        }
        return false;
    }
}
