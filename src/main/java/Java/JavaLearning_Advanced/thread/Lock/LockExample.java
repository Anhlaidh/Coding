package Java.JavaLearning_Advanced.thread.Lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-07 16:41
 */
public class LockExample {
    private static final ReentrantLock queueLock = new ReentrantLock();//可重入锁
    private static final ReentrantReadWriteLock orderLock = new ReentrantReadWriteLock();//可读写锁

    /**
     * 有家奶茶店,点单时需要排队
     * 假设想买奶茶的人如果看到需要排队就等等
     * 假设奶茶店又老板和多名员工,记单方式比较原始,只有一个订单本
     * 老板负责写新订单,员工不断查看订单本得到信息来制作奶茶,在老板写订单时员工不可以看订单本
     * 多个员工可同时看订单本,但此时老板不可写入订单本
     * @param args args
     */
    public static void main(String[] args)  {
//        byMilkTea();
        handleOrder();

    }

    private static void byMilkTea() {
        LockExample lockExample = new LockExample();
        int CUSTOMER_CNT = 10;
        Thread[] customers = new Thread[CUSTOMER_CNT];
        for (int i = 0; i < CUSTOMER_CNT; i++) {
            customers[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long walkingTime = (long) (Math.random() * 1000);
                        Thread.sleep(walkingTime);
                        lockExample.tryToBuyMilkTea();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
            customers[i].start();
        }

    }

    private void tryToBuyMilkTea() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            if (queueLock.tryLock()) {
//                queueLock.lock();
                long thinkingTime = (long) (Math.random() * 500);
                Thread.sleep(thinkingTime);
                System.out.println(Thread.currentThread().getName() + ":来一杯奶茶,不要珍珠");
                flag = false;
                queueLock.unlock();
            } else {
                System.out.println(Thread.currentThread().getName()+":再等等");
            }
            if (flag) {
                Thread.sleep(1000);
            }
        }
    }

    private static void handleOrder() {
        LockExample lockExample = new LockExample();
        Thread boss = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lockExample.addOrder();
                        long waitingTime = (long) (Math.random() * 1000);
                        Thread.sleep(waitingTime);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }

        });
        boss.start();
        int WORKER_CNT = 3;
        Thread[] workers = new Thread[WORKER_CNT];
        for (int i = 0; i < WORKER_CNT; i++) {
            workers[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            lockExample.viewOrder();
                            long workingTime = (long) (Math.random() * 5000);
                            Thread.sleep(workingTime);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            });
            workers[i].start();

        }

    }

    private void viewOrder() throws InterruptedException {
        orderLock.readLock().lock();
        long readingTime = (long) (Math.random() * 500);
        Thread.sleep(readingTime);
        System.out.println(Thread.currentThread().getName()+":查看订单");
        orderLock.readLock().unlock();
    }

    private void addOrder() throws InterruptedException {
        orderLock.writeLock().lock();
        long writingTime = (long) (Math.random() * 1000);
        Thread.sleep(writingTime);
        System.out.println("老板新加一笔订单");
        orderLock.writeLock().unlock();
    }
}
