package Interview.Left.ViolentRecursion;

import java.util.ArrayList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-20 11:45
 */
public class subSequence {
    public static void main(String[] args) {
        solution("abc");

    }

    static void process1(char[] chars, int index, ArrayList<String> ans, String path) {
        if (index == chars.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process1(chars, index+1, ans, no);
        String yes = path + chars[index];
        process1(chars, index+1, ans, yes);
    }

    static void solution(String str) {
        ArrayList<String> ans = new ArrayList<>();
        process1(str.toCharArray(), 0, ans, "");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));

        }

    }
}
