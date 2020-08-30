package Java.JavaLearning_Advanced.thread.mashibing.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-21 10:55
 */
public class TransferQ {
    static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    static char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

   static LinkedTransferQueue<Integer> ints = new LinkedTransferQueue<>();
   static LinkedTransferQueue<Character> characters = new LinkedTransferQueue<>();

    public static void main(String[] args) {

        new Thread(() -> {
            int size = nums.length;
            for (int i = 0; i < size; i++) {
                try {
                    ints.transfer(nums[i]);
                    System.out.print(characters.take() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(()->{
            int size = chars.length;
            for (int i = 0; i < size; i++) {
                try {
                    System.out.print(ints.take());
                    characters.transfer(chars[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
