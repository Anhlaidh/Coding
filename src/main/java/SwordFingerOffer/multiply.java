package SwordFingerOffer;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-11 13:51
 */
public class multiply {
    public static void main(String[] args) {
        int[] numbers = new int[]{
               1,2,3,4,5
        };
        multiply multiply = new multiply();
        int[] multiply1 = multiply.multiply(numbers);
        for (int i = 0; i < multiply1.length; i++) {
            System.out.println(multiply1[i]);
        }

    }
    public int[] multiply(int[] A) {
        int[] result = new int[A.length];
        int current = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j==i) {
                    continue;
                }
                current *= A[j];
            }

            result[i] = current;
            current = 1;
        }
        return result;

    }
}
