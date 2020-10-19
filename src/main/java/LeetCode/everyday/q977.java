package LeetCode.everyday;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-16 13:37
 */
public class q977 {
    public static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = A[i]*A[i];
        }
        //排序
        sort(result,0,result.length-1);
        return result;
    }

    private static void sort(int[] arr, int start, int end) {
        if (end<=start) return;
        int mid= arr[new Random().nextInt(end-start)+start];
        int leftIndex = start-1;
        int cur = start;
        int rightIndex = end+1;
        while (cur < rightIndex) {
            if (arr[cur] < mid) {
                swap(arr, leftIndex + 1, cur);
                cur++;
                leftIndex++;
                continue;
            }
            if (arr[cur] == mid) {
                cur++;
                continue;
            }
            if (arr[cur] > mid) {
                rightIndex--;
                swap(arr, cur, rightIndex);
            }

        }
        sort(arr, start, leftIndex);
        sort(arr, rightIndex, end);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -3, -3, -2, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        int[] ints = sortedSquares(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

}
