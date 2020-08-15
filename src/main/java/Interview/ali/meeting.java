package Interview.ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-22 21:39
 */
public class meeting {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int cp = reader.nextInt();
        int[] people = new int[cp * 2];
        for (int i = 0; i < people.length; i++) {
            people[i] = reader.nextInt();
        }

        int[] dp = new int[cp];
        for (int i = 0; i < dp.length; i++) {

            //找到两个坐标,并进行交换

            if (i == 0) {
                dp[i] = change(people, 2 * i+1, Search(people, 2 * i+1, people[2 * i]));
                continue;
            }
            if (people[2 * i] == people[2 * i + 1]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + change(people, 2 * i+1, Search(people, 2 * i + 1, people[2 * i]));

        }
        System.out.println(dp[cp - 1]);

    }

    private static int Search(int[] ints, int start,int key) {
        for (int i = start; i < ints.length; i++) {
            if (ints[i]==key) return i;
        }
        return -1;

    }

    //交换,并次数加一
    private static int change(int[] people, int a, int b) {
//        int temp = people[a];
//        people[a] = people[b];
//        people[b] = temp;
//        return 1;
        int temp = people[b];
        int count = 0;
        for (int i = b-1; i >= a; i--) {
            people[i + 1] = people[i];
            count++;
        }
        people[a] = temp;
        return count;
    }
}
