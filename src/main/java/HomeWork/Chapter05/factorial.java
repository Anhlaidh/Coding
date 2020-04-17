package HomeWork.Chapter05;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/15 0015 22:35
 */
public class factorial {
    BigInteger factorial(int[] arr){
        if (arr.length<=1) return new BigInteger(arr[0]+"");
        else {
            int[] left = Arrays.copyOfRange(arr,0,arr.length/2);
            int[] right = Arrays.copyOfRange(arr,arr.length/2,arr.length);
            return factorial(left).multiply(factorial(right));
        }
    }
    static int[] init(int n){
        int[] arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i]=i+1;
        }
        return arr;
    }
    public static void main(String[] args) {
        factorial factorial = new factorial();
        System.out.println(factorial.factorial(init(100)));

  }
}
