package Java.JavaLearning.Number;

import java.math.BigInteger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/12 0012 17:41
 */
public class testBigInteger {
    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("123456789999999999999999999999999999999999999999999999999999999");
        BigInteger b2 = new BigInteger("987654321");
        System.out.println("加法操作："+b2.add(b1));
        System.out.println("减法操作："+b2.subtract(b1));
        System.out.println("乘法操作："+b2.multiply(b1));
        System.out.println("除法操作："+b2.divide(b1));
        System.out.println("最大值："+b2.max(b1));
        System.out.println("最小值："+b2.max(b2));

        BigInteger[] result = b2.divideAndRemainder(b1);
        System.out.println("商是："+result[0]+"余数是"+result[1]);
        System.out.println("等价性是:"+b1.equals(b2));
        int flag = b1.compareTo(b2);
        switch (flag){
            case -1:
                System.out.println("比较操作:b1<b2");
                break;
            case 0:
                System.out.println("比较操作:b1==b2");
                break;
            case 1:
                System.out.println("比较操作:b1>b2");
                break;
        }
     }
}
