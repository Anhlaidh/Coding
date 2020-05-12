package Java.JavaLearning_Advanced.thread.ScheduledExecutor;

import Java.JavaLearning_Advanced.thread.Executor.example1.Task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-11 17:20
 */

public class ScheduledExecutorTest {
    public static void main(String[] args) throws InterruptedException {
//        executeAtFixTime();
        executeFixRate();
//        executeFixedDelay();
    }

    private static void executeFixedDelay() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(
                new MyTask(),
                1,
                3000,
                TimeUnit.MICROSECONDS

        );
        Thread.sleep(2000);
        executor.shutdown();

    }

    private static void executeFixRate() throws InterruptedException {


    }

    private static void executeAtFixTime() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(
                new MyTask(),
                1,
                TimeUnit.SECONDS
        );
        Thread.sleep(2000);
        executor.shutdown();
    }

    private static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("时间为:"+new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
