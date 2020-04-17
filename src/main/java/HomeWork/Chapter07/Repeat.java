package HomeWork.Chapter07;

import HomeWork.sort.SortImpl;

import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 15:34
 */
public class Repeat {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 6, 9, 7, 8, 4};
        System.out.println(hasRepeat(arr));
    }

    private static boolean hasRepeat(int[] arr) {
        SortImpl sort = new SortImpl();
        sort.MergeSort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==arr[i-1]) return true;
        }
        return false;

    }
}
