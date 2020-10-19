package test.blubridge;

import java.math.BigInteger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-16 20:53
 */
public class gcd {

    public static void main(String[] args) {
        BigInteger a = new BigInteger("2020");
        BigInteger b = new BigInteger("520");
        a = fibonacci(a);
        b = fibonacci(b);
//        for (int i = 1; i < 20; i++) {
//            System.out.println(fibonacci(new BigInteger(i+"")));
//        }
        System.out.println(a.gcd(b));;
    }

    private static BigInteger fibonacci(BigInteger a) {
        if (a.intValue()==1||a.intValue()==2) return new BigInteger(1+"");
        BigInteger x = new BigInteger("1");
        BigInteger y = new BigInteger("1");
        BigInteger z = x.add(y);
        for (int i = 3; i < a.intValue(); i++) {
            x = y;
            y = z;
            z = x.add(y);
        }
        return z;
    }
}
