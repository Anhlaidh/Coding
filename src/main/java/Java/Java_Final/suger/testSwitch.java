package Java.Java_Final.suger;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-07 17:16
 */
public class testSwitch {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        Scanner scanner = new Scanner(System.in);
        int num= scanner.nextInt();
        int days = switch (num){
            case 1,3,5,7,8,10,12 -> 31;
            case 4,6,9,11 -> 30;
            default -> 28;
        };
        System.out.println(days);
    }

    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.next();
        int result=-1;
        switch (month) {
            case "Jan","Mar","May","July","Aug","Oct","Dec" -> result = 31;
            case "Apr","June","Sep","Nov" -> result = 30;
            case "Feb" -> result = 28;
            default -> result = -1;


        }
        System.out.println(result);
    }
}
