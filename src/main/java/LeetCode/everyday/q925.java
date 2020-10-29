package LeetCode.everyday;

import org.quartz.TimeOfDay;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-21 14:48
 */
public class q925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("dfuyalc",
                "fuuyallc"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        if (name.length() == typed.length()) {
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != typed.charAt(i)) {
                    return false;
                }
            }
        }
        else if (name.length() < typed.length()) {

            int j = 0;
            int i = 0;
            char[] names = name.toCharArray();
            char[] typeds = typed.toCharArray();
            if (names[i]!=typeds[j]) return false;
            while (i < names.length&&j<typeds.length) {
                if (names[i] == typeds[j]) {
                    i++;
                    j++;
                    continue;
                }
                if (typeds[j] == typeds[j - 1] && names[i] != typeds[j]) {
                    j++;
                } else {
                    break;
                }
            }
            while (j<typeds.length&&typeds[j] == names[names.length - 1]) {
                j++;
            }
            if (i != names.length||j<typeds.length) {
                return false;
            }

        } else {
            return false;
        }
        return true;
    }

}
