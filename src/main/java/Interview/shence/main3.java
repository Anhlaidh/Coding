package Interview.shence;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-04-02 12:17
 */
public class main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int length = reader.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = reader.nextInt();
        }
        int start_index = reader.nextInt();
        int count = reader.nextInt();
        for (int i = start_index; i < arr.length; i++) {
            System.out.println(arr[i]);
            count--;
            if (count<0) break;
        }
        int index = length - 1;
        boolean isRight = false;
        while (count-- > 0) {

            if (index>=length-1) isRight = false;
            if (index<=0) isRight = true;
            if (isRight) {
                index += 1;
            } else {
                index -= 1;
            }
            System.out.println(arr[index]);

        }


    }
}
