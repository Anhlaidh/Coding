package Java.JavaLearning_Advanced.thread.Fork_Join;

import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-09 13:37
 */
public class SumTask extends RecursiveTask<Long> {
    private int start;
    private int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static final int THREAD_HOLD = 5;

    @Override
    protected Long compute() {
        Long sum = 0L;
        //如果任务足够小,就直接执行(中断)
        boolean canCompute = (end - start) <= THREAD_HOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum = sum + i;
            }
        } else {
            //任务大于阈值,分裂为两个任务
            int middle = (start + end) / 2;
            SumTask subTask1 = new SumTask(start, middle);
            SumTask subTask2 = new SumTask(middle+1, end);
            invokeAll(subTask1,subTask2);

            Long sum1 = subTask1.join();
            Long sum2 = subTask2.join();
            sum = sum1 + sum2;

        }
        return sum;
    }
}
