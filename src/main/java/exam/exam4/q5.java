package exam.exam4;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-26 21:08
 */
public class q5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        for (int i = 0; i < N; i++) {
            BigInteger x = new BigInteger(reader.next());
            int k = reader.nextInt();
            BigInteger j = new BigInteger("1");
            int deep = 0;
            while (j.compareTo(x)<0) {
                j = j.multiply(new BigInteger("2"));
                deep++;
            }
            if (k >= deep) {
                System.out.println(-1);
                continue;
            }
            for (int p = 0; p < deep-k; p++) {
                x = x.divide(new BigInteger("2"));
            }
            System.out.println(x.toString());

        }
    }
}
