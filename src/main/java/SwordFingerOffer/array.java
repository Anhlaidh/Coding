package SwordFingerOffer;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-11 13:35
 */
public class array {
    public static void main(String[] args) {

        int[] numbers = new int[]{
                1, 3, 5, 6, 4, 2,0
        };


        System.out.println(duplicate(numbers,numbers.length, numbers));

    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean[] flags = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (flags[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;

            }
            flags[numbers[i]] = true;

        }
        return false;

    }
}
