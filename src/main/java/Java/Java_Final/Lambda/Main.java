package Java.Java_Final.Lambda;

import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-06 21:38
 */
public class Main {
    public static void main(String[] args) {
        String[] s = new String[]{"aaa", "bbbb", "cccccc"};
        StringChecker eventLength = s1 -> {
            if (s1.length() % 2 == 0) {
                return true;
            }
            return false;
        };

        for (String p : s) {
            if (eventLength.test(p)) {
                System.out.println(p);

            }
        }
    }

}
