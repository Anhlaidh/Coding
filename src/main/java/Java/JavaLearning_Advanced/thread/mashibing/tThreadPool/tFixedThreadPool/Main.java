package Java.JavaLearning_Advanced.thread.mashibing.tThreadPool.tFixedThreadPool;

import java.util.concurrent.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-22 15:08
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        MyTask task1 = new MyTask(1, 80000);
        MyTask task2 = new MyTask(80000, 130000);
        MyTask task3 = new MyTask(130001, 170000);
        MyTask task4 = new MyTask(170001, 200000);
        Future<Integer> f1 = service.submit(task1);
        Future<Integer> f2 = service.submit(task2);
        Future<Integer> f3 = service.submit(task3);
        Future<Integer> f4 = service.submit(task4);
        int count = 0;
        long start = System.currentTimeMillis();
        try {
            count = f1.get() + f2.get() + f3.get() + f4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
        System.out.println("count:" + count);
        service.shutdown();
    }

    private static class MyTask implements Callable<Integer> {
        int start;
        int end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isPrime(int num) {
            for (int i = 2; i < num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        Integer getPrime() {
            int count = 0;
            for (int i = start; i < end; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        @Override
        public Integer call() throws Exception {
            return getPrime();
        }
    }
}
