package Interview.Left.ViolentRecursion;

import java.util.ArrayList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-20 19:10
 */
public class AllPermutationsBAB {
    public static void main(String[] args) {
        solution("abc");
    }

    private static void solution(String abc) {
        ArrayList<String> list = new ArrayList<>();
        process(abc.toCharArray(), list, 0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }

    private static void process(char[] str, ArrayList<String> list, int i) {
        if (i == str.length) {
            list.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, list, i + 1);
                swap(str, i, j);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
