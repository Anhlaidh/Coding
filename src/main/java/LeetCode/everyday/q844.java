package LeetCode.everyday;

import java.util.ArrayList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-19 12:59
 */
public class q844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("isfcow#",
                "isfco#w#"));

    }

    public static boolean backspaceCompare(String S, String T) {
        ArrayList<Character> SList = new ArrayList<>();
        ArrayList<Character> TList = new ArrayList<>();
        char[] Ss = S.toCharArray();
        char[] Ts = T.toCharArray();
        for (int i = 0; i < Ss.length; i++) {

            if (Ss[i] == '#') {
                if (!SList.isEmpty()) {
                    SList.remove(SList.size() - 1);
                }

            } else {
                SList.add(Ss[i]);
            }
        }
        for (int i = 0; i < Ts.length; i++) {

            if (Ts[i] == '#') {
                if (!TList.isEmpty()) {
                    TList.remove(TList.size() - 1);
                }

            } else {
                TList.add(Ts[i]);
            }
        }
        if (SList.size()!=TList.size()) return false;
        for (int i = 0; i < SList.size(); i++) {
            if (!SList.get(i).equals(TList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
