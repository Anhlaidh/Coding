package Interview.shence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * 从左往右尝试模型,  钱数 求可能性  第三类型此题目
 * 动态规划
 * @author: Anhlaidh
 * @date: 2021-04-02 12:01
 */
public class main2 {

    static int[] price = new int[]{1, 2, 5, 10, 20, 50,100};
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = 7;
        int[] wallet = new int[N];
        for (int i = 0; i < N; i++) {
            wallet[i] = reader.nextInt();
        }
        List<int[]> result = new ArrayList<>();
        int target = reader.nextInt();
        int[] used = new int[N];
        method(wallet, target, used, result);
        // 张数
        // 目标
        for (int i = 0; i < result.size(); i++) {
            int[] ints = result.get(i);
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j]+" ");
            }
            System.out.println();
        }

    }

    static void method(int[] wallet, int target, int[] used,List<int[]> result) {
        if (target == 0) {
            if (contains(result, used)) {
                return;
            } else {
                result.add(used.clone());
            }
            return;

        }
        if (target<0) return ;
        for (int i = 0; i < wallet.length; i++) {
            int cur_price = price[i];
            if (wallet[i]==0) continue;
            wallet[i] -= 1;
            used[i] += 1;
            method(wallet, target - cur_price, used, result);
            //回溯
            wallet[i] += 1;
            used[i] -= 1;
        }

    }

    private static boolean contains(List<int[]> result, int[] used) {
        for (int i = 0; i < result.size(); i++) {
            int[] ints = result.get(i);
            for (int j = 0; j < ints.length; j++) {

                if (ints[j] != used[j]) {
                    break;
                } else {
                    if (j == ints.length - 1 && ints[j] == used[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
