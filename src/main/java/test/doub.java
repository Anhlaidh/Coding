package test;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-16 15:19
 */
public class doub {
        static Thread a;
        static Thread b;
    public static void main(String[] args) {
        a = new Thread(() -> {
            try {
                System.out.println("a is running");
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA");
        b = new Thread(() -> {
            try {
                System.out.println("b is running");
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB");
        a.start();
        b.start();


    }
}
