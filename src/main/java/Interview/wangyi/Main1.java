package Interview.wangyi;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-08 15:01
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int size = reader.nextInt();
        int[] arr = new int[size];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / 2;
        }
        System.out.println(sum);

    }
}
