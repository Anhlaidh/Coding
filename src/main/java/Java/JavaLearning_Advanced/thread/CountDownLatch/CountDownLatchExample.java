package Java.JavaLearning_Advanced.thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-08 10:58
 */
public class CountDownLatchExample {
    /**
     * 设想百米赛跑比赛,发令枪发出信号后选手开始跑,全部选手跑到终点后比赛结束
     * @param args args
     * @throws InterruptedException Interrupted Exception
     */
    public static void main(String[] args) throws InterruptedException {
        int runnerCnt = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(runnerCnt);
        for (int i = 0; i < runnerCnt; i++) {//create and start threads
            new Thread(new Worker(startSignal,doneSignal)).start();
        }
        System.out.println("准备工作");
        System.out.println("准备工作就绪");
        startSignal.countDown();//let all thread proceed
        System.out.println("比赛开始");
        doneSignal.await();//wait for all to finish

    }

    private static class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch downSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch downSignal) {
            this.startSignal = startSignal;
            this.downSignal = downSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                Thread.sleep((long)(Math.random()*500));
                doWork();
                downSignal.countDown();
            } catch (InterruptedException e) {
                //return;
            }

        }

        private void doWork() {
            System.out.println(Thread.currentThread().getName()+":跑完全程");
        }
    }
}
