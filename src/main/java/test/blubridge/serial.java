package test.blubridge;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-16 21:17
 */
public class serial {
    public static void main(String[] args) {
        System.out.println((char)65);
        Scanner reader = new Scanner(System.in);
        String a = reader.next();
        char[] chars = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int cur = Integer.parseInt(chars[i] + "");
            if (i < chars.length - 1 &&cur == 2) {
                int next = Integer.parseInt(chars[i + 1] + "");
                if ( next <= 6) {
                    cur = 2 * 10 + next;
                    sb.append((char) (65 + cur-1));
                    i++;
                }
            } else if (i < chars.length - 1 &&cur == 1) {
                int next = Integer.parseInt(chars[i + 1] + "");
                cur = 10 + next;
                sb.append((char) (65 + cur-1));
                i++;
            } else {
                sb.append((char) (65 + cur-1));


            }
        }
        System.out.println(sb.toString());
    }
}
