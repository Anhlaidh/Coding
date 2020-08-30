package SwordFingerOffer;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-11 22:35
 */
public class match {
    public static void main(String[] args) {
        char[] str = new char[]{
                'a'


        };
        char[] pattern = "ab*".toCharArray();
        System.out.println(match(str, pattern));



    }

    public static boolean match(char[] str, char[] pattern) {
        if (pattern.length==2&&pattern[0]=='.'&&pattern[1]=='*') {
            return true;
        }

        int i = 0;
        int p = 0;
        if (str.length == 0&&pattern.length>=2) {
            for (int j = 1; j < pattern.length; j +=2) {
                if (pattern.length%2!=0) {
                    return false;
                }
                if (pattern[j] != '*') {
                    return false;
                }

            }
            return true;

        }
        while (i<str.length){
            if (p>=pattern.length) {
                return false;
            }

            if (str[i] != pattern[p]) {
                if (pattern[i] == '.') {
                    if (i==str.length-1){
                        p++;
                        i++;
                        break;
                    }


                    if (pattern[i + 1] == '*') {
                        p++;
                    }
                    i++;
                    p++;
                    continue;
                }
                if (pattern[p + 1] == '*') {
                    char match = pattern[p];
                    int begin = i;
                    while (true) {
                        if (str[begin]==pattern[p-1]&&i==str.length-1) {
                            return true;
                        }
                        if (str[begin] == pattern[p-1] && str[i + 1] == pattern[p + 2]) {
                            p = p + 2;
                            break;
                        } else {
                            if (str[begin] != pattern[p] || str[i] != match) {
                                return false;
                            } else {
                                i++;
                                break;
                            }
                        }
                    }

                }

            }
            p++;
            i++;

        }
        if (p!=pattern.length) {
            return false;
        }
        return true;

    }
}
