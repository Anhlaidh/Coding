package Java.JavaLearning_Advanced.thread.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 22:05
 */
public class DeadLock {
    public static Integer r1 = 1;
    public static Integer r2 = 2;
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
        Thread2 t2 = new Thread2();
        t2.start();

    }

}

class Thread1 extends Thread {
    @Override
    public void run() {
        //先要r1再要r2
        synchronized (DeadLock.r1) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock.r2) {
                System.out.println("Thread1 is running");
            }
        }
    }
}
class Thread2 extends Thread {
    @Override
    public void run() {
        //先要r2再要r1
        synchronized (DeadLock.r2) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock.r1) {
                System.out.println("Thread2 is running");
            }
        }
    }
}
