package HomeWork.Chapter06;

import HomeWork.sort.SortImpl;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/1 0001 15:15
 */
public class insertSort {
    public static void main(String[] args) {
        SortImpl sort = new SortImpl();
        Random random = new Random();
        int[] arr = random.ints(10,0,100).toArray();
        sort.InsertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
