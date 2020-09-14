package Java.JavaLearning_Advanced.thread.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-07 12:01
 */
public class testLockPark {
    static Lock lock = new ReentrantLock();

    static void method(Lock lock) {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ":Lock");
        LockSupport.park();
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            method(lock);
        },"Thread 1").start();
        Thread.sleep(500);
        new Thread(() -> {
            method(lock);
        }, "Thread 2").start();
    }
}
