package HomeWork.Chapter11;

import HomeWork.sort.SortImpl;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-06-05 14:24
 */
public class CountSort {
    public static void main(String[] args) {
        SortImpl sort = new SortImpl();
        Random random = new Random();
        int[] arr = random.ints(20, 0, 10).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        int[] ints = sort.CountSort(arr, 0, 10);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
