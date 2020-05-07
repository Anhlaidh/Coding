package Java.JavaLearning_Advanced.thread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-07 17:48
 */
public class SemaphoreExample {
    private final Semaphore placeSemaphore = new Semaphore(5);
    public boolean parking() {
        if (placeSemaphore.tryAcquire()) {
            System.out.println(Thread.currentThread().getName() + "停车成功");
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + "没有空位");
            return false;
        }
    }
    public void leaving() {
        placeSemaphore.release();
        System.out.println(Thread.currentThread().getName()+":开走");
    }

    /**
     * 一个车库,五个车位,十辆车需要停放,每次停放时,申请信号量
     * @param args args
     * @throws InterruptedException exception
     */
    public static void main(String[] args) throws InterruptedException {
        int tryToParkCnt = 10;
        SemaphoreExample semaphoreExample = new SemaphoreExample();
        Thread[] parkers = new Thread[tryToParkCnt];
        for (int i = 0; i < tryToParkCnt; i++) {
            parkers[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long randomTime = (long) (Math.random() * 1000);
                        Thread.sleep(randomTime);
                        if (semaphoreExample.parking()) {
                            long parkingTime = (long) (Math.random() * 1000);
                            Thread.sleep(parkingTime);
                            semaphoreExample.leaving();
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
            parkers[i].start();

        }
        for (int i = 0; i < tryToParkCnt; i++) {
            parkers[i].join();
        }


    }
}
