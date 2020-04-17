package HomeWork.Chapter07;

import HomeWork.sort.SortImpl;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:模式运算
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 15:42
 */
public class ModeOperation {
    static int num;//最多的数字
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = random.ints(100, 0, 10).toArray();
        System.out.println("次数："+getTimes(arr));
        Arrays.sort(arr);
        System.out.println("数组：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("值："+num);
    }

    private static int getTimes(int[] arr) {
        num = 0;
        SortImpl sort = new SortImpl();
        sort.MergeSort(arr);//数组排序
        int count = 0;//初始化计数
        for (int i = 1; i < arr.length; i++) {
            int currentTimes = 1;//局部计数器
            while (i<arr.length&&arr[i] == arr[i - 1]) {
                currentTimes++;//当重复时计数器加一
                i++;
            }
           if (count<currentTimes) num = arr[i-1];
            count = Math.max(count, currentTimes);//找到次数最多的并赋值

        }
        return count;
    }
}
