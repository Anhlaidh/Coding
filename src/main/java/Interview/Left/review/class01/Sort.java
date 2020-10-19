package Interview.Left.review.class01;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-10 14:47
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new Random().ints(10, 0, 100).toArray();
        System.out.println("arr:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        int[] select = Arrays.copyOfRange(arr, 0, arr.length);
        selection(select);
        System.out.println("selection: 时间复杂度 O(n2) 空间复杂度 O(1)");
        for (int i = 0; i < select.length; i++) {
            System.out.print(select[i] + "\t");

        }
        System.out.println();
        int[] bubble = Arrays.copyOfRange(arr, 0, arr.length);
        bubble(bubble);
        System.out.println("bubble: 时间复杂度O(n2) 空间复杂度O(1)");
        for (int i = 0; i < bubble.length; i++) {
            System.out.print(bubble[i] + "\t");

        }
        System.out.println();
        int[] insert = Arrays.copyOfRange(arr, 0, arr.length);
        insert(insert);
        System.out.println("insert: 时间复杂度O(n2) 空间复杂度O(1)");
        for (int i = 0; i < bubble.length; i++) {
            System.out.print(bubble[i] + "\t");

        }
    }

    private static void insert(int[] insert) {
        for (int i = 0; i < insert.length; i++) {
            for (int j = i + 1; j < insert.length; j++) {
                if (insert[i] < insert[j]) {
                    for (int k = j; k > 0; k--) {
                        if (insert[k]<insert[i]) swap(insert, k, i);
                    }
                } else {
                    break;
                }
            }
        }
    }

    private static void bubble(int[] bubble) {
        for (int i = 0; i < bubble.length; i++) {
            for (int j = 0; j < bubble.length - i-1; j++) {
                if (bubble[j]>bubble[j+1]) swap(bubble, j, j + 1);
            }
        }
    }

    private static void selection(int[] select) {
        for (int i = 0; i < select.length-1; i++) {
            int minIndex = i;
            for (int j = i; j < select.length; j++) {
                minIndex = select[minIndex] < select[j] ? minIndex : j;
            }
            swap(select, minIndex, i);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
