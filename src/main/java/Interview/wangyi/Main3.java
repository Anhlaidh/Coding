package Interview.wangyi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-08 15:26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        while (N-- > 0) {
            int size = reader.nextInt();
            //定义赋值
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = reader.nextInt();
            }
            Arrays.sort(arr);
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = size - 1; i >= 0; i--) {
                list.add(arr[i]);
            }
            list.add(0);
            int index = 0;
            while (index < list.size()) {
                int aIndex = index + 1;
                if (aIndex+1>list.size()) {
                    break;
                }
                int current = list.get(index);
                int bIndex = list.lastIndexOf(current - list.get(aIndex));
                if (bIndex>list.size()) {
                    break;
                }
                if (bIndex > 0 && aIndex != bIndex && aIndex != index && bIndex != index) {

                    list.remove(bIndex);
                    list.remove(aIndex);
                    list.remove(index);
                } else {
                    index++;
                }

            }
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            System.out.println(sum);

        }

    }
}
