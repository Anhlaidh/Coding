package ACM;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-13 16:58
 */
public class difference {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] a = new int[reader.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = reader.nextInt();
        }
        int[] b = new int[reader.nextInt()];
        for (int i = 0; i < b.length; i++) {
            b[i] = reader.nextInt();
        }
    }
}
