package exam.exam2;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-09 19:17
 */
public class doub {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        StringBuffer[] str = new StringBuffer[N];
        for (int i = 0; i < N; i++) {
            str[i] = new StringBuffer(reader.next());
            for (int l = 0; l < str[i].length()-2; l++) {
                if (str[i].charAt(l) == str[i].charAt(l + 1) && str[i].charAt(l) == str[i].charAt(l + 2)) {
                    str[i].deleteCharAt(l);
                    l = 0;
                }
            }
            for (int l = 0; l < str[i].length()-3; l++) {
                if (str[i].charAt(l) != str[i].charAt(l + 1)) continue;
                if (str[i].charAt(l+2)!=str[i].charAt(l+3)) continue;
                else str[i].deleteCharAt(l + 2);

            }

        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

    }
}
