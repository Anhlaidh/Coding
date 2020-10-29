package Interview.meituan;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-25 10:12
 */
public class q2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        char[] chars = str.toCharArray();
        int up = 0;
        int down = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                down++;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                up++;
            }
        }
        System.out.println(Math.abs(up-down)/2);
    }
}
