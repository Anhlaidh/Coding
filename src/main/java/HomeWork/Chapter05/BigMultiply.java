package HomeWork.Chapter05;

import java.math.BigInteger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/20 0020 20:02
 */
public class BigMultiply {

    public static void main(String[] args) {
        int a = 1234;
        int b = 5678;
        System.out.println(multiply(a, b, 2));
    }

    private static int multiply(int a, int b, int n) {
        int A =a/(int)Math.pow(10,n/2);
        int B = a%A;
        int C = b / (int) Math.pow(10, n / 2);
        int D = b % C;
        return (int)(Math.pow(10, n)*(A*B) + Math.pow(10, n / 2)*(A+B)*(C+D)-A*C-B*D)+A*C;
    }
}
