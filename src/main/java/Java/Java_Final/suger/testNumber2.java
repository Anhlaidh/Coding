package Java.Java_Final.suger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-07 15:40
 */
public class testNumber2 {
    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test2() {
        long a1 = 9999999999L;
        long a2 = 9_999_999_999L;
        int a3 = 0b0111_1011_0001;//二进制0b开头
        int a4 = 02_014;//8进制,0开头
        int a5 = 123__45;//可以多个下划线
        int a6 = 0x7_B_1;//十六进制
        float a7 = 3.56_78f;//float
        double a8 = 1.3_45_67;//double

//        int b1 = 0b_123_4; _必须在数字之间
//        int b2 = 0123_4_;不能在末尾
//        int b3 = _123;不能在开头
//        int b4 = 0_ x_123;不能拆开0x
//        int b5 = 0x_51;_必须在数字之间
//        long b6 = 1000_L;_必须在数字之间
//        float b7 = 1.34f _;_不能在末尾

    }

    private static void test1() {
        byte a1 = (byte) 0b00100001;
        short a2 = (short) 0b001010100;
        int a3 = 0b0010101010;
        int a4 = 0b101;
        int a5 = 0B101;//B可以大小写
        long a6 = 0b1010101010010010010101010L;
        final int[] s1 = {0b101010, 0b101101, 0b1101111, 0b1111};
        System.out.println(a5);
        System.out.println(Integer.toBinaryString(a5));
    }

}
