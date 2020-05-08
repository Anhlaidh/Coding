package Java.JavaLearning_Advanced.thread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-08 18:36
 */
public class CyclicBarrierExample {
    /**
     * 假定三行数,用三个线程分别计算每一行的和,最终计算总和
     * @param args args
     */
    public static void main(String[] args) {
        final int[][] numbers = new int[3][5];
        final int[] results = new int[3];
        int[] row1 = new int[]{1, 2, 3, 4, 5};
        int[] row2 = new int[]{6, 7, 8, 9, 10};
        int[] row3 = new int[]{11, 12, 13, 14, 15};
        numbers[0] = row1;
        numbers[1] = row2;
        numbers[2] = row3;
        CalculateFinalResult finalResult = new CalculateFinalResult(results);
        CyclicBarrier barrier = new CyclicBarrier(3, finalResult);
        //当有三个线程在barrier上await,就执行finalResultCalculator
        for (int i = 0; i < 3; i++) {
            CalculateEachRow rowCalculator = new CalculateEachRow(barrier, numbers, i, results);
            new Thread(rowCalculator).start();
        }


    }

    private static class CalculateFinalResult implements Runnable {
        final int[] eachRowRes;
        int finalRes;

        public CalculateFinalResult(int[] eachRowRes) {
            this.eachRowRes = eachRowRes;
        }

        public int getFinalRes() {
            return finalRes;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int data : eachRowRes) {
                sum += data;
            }
            finalRes = sum;
            System.out.println("最终结果为:" + finalRes);

        }
    }

    private static class CalculateEachRow implements Runnable{
        final CyclicBarrier barrier;
        final int[][] numbers;
        final int rowNumber;
        final int[] res;

        public CalculateEachRow(CyclicBarrier barrier, int[][] numbers, int rowNumber, int[] res) {
            this.barrier = barrier;
            this.numbers = numbers;
            this.rowNumber = rowNumber;
            this.res = res;
        }

        @Override
        public void run() {
            int[] row = numbers[rowNumber];
            int sum = 0;
            for (int i : row) {
                sum += i;
                res[rowNumber] = sum;
            }
            try {
                System.out.println(Thread.currentThread().getName() + ":计算第" + (rowNumber + 1) + "行结束,结果为:" + sum);
                barrier.await();//等待,只要超过3个(Barrier的构造参数),就放行
            } catch (InterruptedException|BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
