package HomeWork.Chapter06;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/1 0001 17:48
 */
public class MinN {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = random.ints(10, 0, 100).toArray();
        for (int i : arr) {
            System.out.print(i+"  ");
        }
        System.out.println();

        System.out.println(min(arr,5));
    }

    private static int min(int[] arr,int n) {
        int mid = arr[0]; //定义中值
        int left = 0;//左指针
        int right = arr.length - 1;// 右指针
        while (left != right) {
            while (left != right) {//左数组
                if (arr[right] < mid) {
                    arr[left] = arr[right];
                    left++;
                    break;
                } else right--;
            }
            while (left != right) {//右数组
                if (arr[left] > mid) {
                    arr[right] = arr[left];
                    right--;
                    break;
                } else left++;
            }
        }
        arr[left] = mid;//中值赋值
        if (left==n-1) return arr[left];//跳出递归
        if (left > n) {
            return min(Arrays.copyOfRange(arr, 0, left), n);
        } else return min(Arrays.copyOfRange(arr, right+1, arr.length), n - left-1);


    }

}
