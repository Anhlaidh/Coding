package ACM;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-13 14:58
 */
public class CaptchaCracker {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();

        for (int i = 0; i < N; i++) {
            StringBuffer result = new StringBuffer();
            String input = reader.next();
            if (input.length()==0) System.out.println("");
            for (int j = 0; j < input.length(); j++) {
                char current = input.charAt(j);

                if (current==48) result.append(0);
                if (current==50) result.append(2);
                if (current==52) result.append(4);
                if (current==54) result.append(6);
                if (current==57) result.append(9);
                if (current !='z'&&
                current !='f'&&
                current !='n'&&
                current !='t'&&
                current !='s'
                ) continue;

                if (input.length() - j >= 4) {
                    String substring = input.substring(j, j + 4);
                    if ("zero".equals(substring)) result.append(0);
                    if ("four".equals(substring)) result.append(4);
                    if ("nine".equals(substring)) result.append(9);
                }
                if (input.length() - j >= 3) {
                    String substring = input.substring(j, j + 3);
                    if ("two".equals(substring)) result.append(2);
                    if ("six".equals(substring)) result.append(6);
                }
            }
            System.out.println(result);
        }
    }
}
