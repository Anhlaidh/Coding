package test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-14 18:18
 */
public class getCurrent {
    static int a;
    static int[] c;
    int b = 5;
    public static void main(String[] args) throws InterruptedException {
//        while (true) {
//            Thread.sleep(1000);
//            System.out.println(System.currentTimeMillis()+86400000 );
//        }

//        System.out.println(a);
//        System.out.println(c.length);
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        LockSupport.park();
    }
}
