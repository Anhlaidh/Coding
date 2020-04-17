package Java.JavaLearning_Advanced.Maven;

import org.apache.commons.math3.util.ArithmeticUtils;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 13:13
 */
public class testGcd {
    public static void main(String[] args) {
        int a = ArithmeticUtils.gcd(361, 285);
        System.out.println("gcd 361,285 is " + a);
    }
}
