package Interview.tencent;

import java.util.Random;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-23 20:50
 */
public class main3 {
//    static void test(){
//        Random random = new Random();
//        int[] ints = random.ints(100, 0, (int) Math.pow(10, 2)).toArray();
////        int[] ints = new int[]{35};
//        for (int i = 0; i < ints.length; i++) {
////            System.out.println(i);
//            if (MaxValue(ints[i]) != maxVal(ints[i])) {
//                System.out.println("============");
//                System.out.println(ints[i]);
//
//                System.out.println(MaxValue(ints[i]));
//
//                System.out.println(maxVal(ints[i]));
//            }
//
//        }
//
//    }

    static int MaxValue(int num) {
        int max = 0;
        for (int i = 0; i < num; i++) {
            int left = num - i;
            int right = i;
            int count = 0;
            while (left / 10 != 0 ) {
                count += left % 10 ;
                left = left / 10;
            }
            while (right/10!=0){
                count += right % 10;
                right = right / 10;
            }
            count += left + right;
            max = Math.max(max, count);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.print(MaxValue(reader.nextInt()));;
        }

    }

//    private static int maxVal(int x) {
//        int left = x / 2;
//        int right = x - left;
//        int count = 0;
//        while (left / 10 != 0 || right / 10 != 0) {
//            count += left % 10 + right % 10;
//            left = left / 10;
//            right = right / 10;
//        }
//        count += left + right;
//        return count;
//
//    }
}
