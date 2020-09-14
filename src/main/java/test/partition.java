package test;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-08 11:33
 */
public class partition {
    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = random.ints(10, 0, 10).toArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
        System.out.println();
        Partition(ints, ints[0]);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }

    private static void Partition(int[] ints,int pivot) {
        int small = -1;
        int large = ints.length;
        int index = 0;
        while (index < large) {
            if (ints[index] < pivot) {
                small++;
                swap(ints, index, small);
                index++;
            }
            else if (ints[index] > pivot) {
                large--;
                swap(ints, index, large);

            } else {
                index++;
            }


        }
    }

    private static void swap(int[] ints, int a, int b) {
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }
}
