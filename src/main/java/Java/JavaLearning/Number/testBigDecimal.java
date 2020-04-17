package Java.JavaLearning.Number;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/12 0012 17:41
 */
public class testBigDecimal {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("123456789.987654321");
        BigDecimal b2 = new BigDecimal("987564321.123456789");
        System.out.println("b1:"+b1+"b2:"+b2);
        System.out.println("加法操作："+b2.add(b1));
        System.out.println("减法操作："+b2.subtract(b1));
        System.out.println("乘法操作："+b2.multiply(b1));
        //需要指定位数，防止无限循环，或者包含在try catch中
        System.out.println("除法操作："+b2.divide(b1,10,BigDecimal.ROUND_UP));

        System.out.println("最大值"+b2.max(b1));
        System.out.println("最小值"+b2.min(b1));

        int flag = b1.compareTo(b2);
        switch (flag){
            case -1 :
                System.out.println("比较操作：b1<b2");
                break;
            case 0 :
                System.out.println("比较操作：b1==b2");
                break;
            case 1 :
                System.out.println("比较操作：b1>b2");
                break;
        }
    }
}
