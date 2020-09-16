package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-16 16:04
 */
public class deadLock {
    static Lock ALock = new ReentrantLock();
    static Lock BLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (BLock) {
                while (true) {
                    System.out.println("aaa");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ALock) {

                    }

                }
            }
        }).start();
        new Thread(() -> {
            synchronized (ALock) {
                while (true) {
                    System.out.println("bbbb");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (BLock) {

                    }

                }
            }
        }).start();
    }
}
