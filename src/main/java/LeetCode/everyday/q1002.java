package LeetCode.everyday;

import java.util.*;


/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-14 11:39
 */
public class q1002 {
    public static void main(String[] args) {
        String[] A = new String[]{"acabcddd","cababaab","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
//        String[] A = new String[]{"bella","label","roller"};
        List<String> list = commonChars(A);
        System.out.println(list);
        //e l l

    }

    public static List<String> commonChars(String[] A) {
        List<Character> list = new LinkedList<>();

        for (int i = 0; i < A[0].length(); i++) {
            list.add(A[0].charAt(i));
        }
        Collections.sort(list);
        for (int i = 1; i < A.length; i++) {
            compare(list, A[i]);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i) + "");
        }
        return result;



    }

    private static List<Character> compare(List<Character> list, String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int i = 0;
        int j = 0;
        while (true) {
            while (i<list.size()&&list.get(i) < chars[j]) {
                list.remove(i);
            }
            while (i<list.size()&&j < chars.length && chars[j] < list.get(i)) {
                j++;
            }
            if (i<list.size()&&j < chars.length && chars[j] == list.get(i)) {
                i++;
                j++;
            }
            if (i >= list.size() || j >= chars.length) {
                break;
            }


        }
        while (i < list.size()) {
            list.remove(i);
        }
        return list;
    }
}
