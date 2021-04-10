package Interview.shence;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-04-02 11:30
 */
public class main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        StringBuilder s = new StringBuilder(reader.next());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char c = s.charAt(i);
                s.replace(i, i+1, String.valueOf((char) (c+'a'-'A')));
                s.insert(i, '_');
                i++;
            }
        }
        if (s.charAt(0) == '_') {
            s.delete(0, 1);
        }
        System.out.println(s.toString());
    }
}
