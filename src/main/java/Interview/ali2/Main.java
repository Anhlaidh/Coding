package Interview.ali2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-24 18:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        //盘子赋值
        int[] disks = new int[n];
        for (int i = 0; i < disks.length; i++) {
            disks[i] = reader.nextInt();
        }
        int sum = 0;
        int count = 0;
        while (findmin(disks) > 0) {
            int min = findmin(disks);
            sum += disks.length * disks[min];
//            min = findminOrder(disks, min);
            disks = Arrays.copyOfRange(disks, 0, min);
            count++;
        }
        sum += (disks[0] - count)*disks.length;

        System.out.println(sum);

    }

    private static int findminOrder(int[] disks,int x) {
        int min = Integer.MAX_VALUE;
        int index = disks.length;
        for (int i = 0; disks[i] <x; i++) {
            if (disks[i] < min) {
                min = disks[i];
                index = i;
            }
        }
        return index;
    }

    private static int findmin(int[] disks) {
        int min = Integer.MAX_VALUE;
        int index = disks.length;
        for (int i = disks.length-1; i >=0; i--) {
            if (disks[i] < min) {
                min = disks[i];
                index = i;
            }
        }
        return index;
    }


}
