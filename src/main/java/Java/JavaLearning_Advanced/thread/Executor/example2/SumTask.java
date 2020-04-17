package Java.JavaLearning_Advanced.thread.Executor.example2;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-08 22:17
 */
public class SumTask implements Callable {
    private int startNumber;
    private int endNumber;

    public SumTask(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = startNumber; i <= endNumber; i++) {
            sum = sum + i;
        }
        Thread.sleep(new Random().nextInt(1000));
        System.out.printf("%s:%d", Thread.currentThread().getName(), sum);
        return sum;
    }
}
