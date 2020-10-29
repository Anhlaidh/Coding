package Interview.meituan;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-25 11:28
 */
public class q5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int A = reader.nextInt();
        int B = reader.nextInt();
        int C = reader.nextInt();
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            int X = reader.nextInt();
            int Y = reader.nextInt();
            int aCount = 0;
            int bCount = 0;
            int cCount = 0;
            while (X >= 2 && Y >= 2) {
                X = X / 2;
                Y = Y / 2;
                cCount++;
            }
            while (X >= 2) {
                X = X / 2;
                bCount++;
            }
            while (Y >= 2) {
                Y = Y / 2;
                aCount++;
            }
            System.out.println(A*aCount+B*bCount+C*cCount);

        }
    }
}
