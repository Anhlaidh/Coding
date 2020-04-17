package Java.JavaLearning_Advanced.thread.Executor.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-08 22:15
 */
public class SumTest {
    public static void main(String[] args) {
        //执行线程池
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
        List<Future<Integer>> resultList = new ArrayList<>();
        //统计1-1000总和,分成10个任务计算,提交任务
        for (int i = 0; i < 10; i++) {
            SumTask calculator = new SumTask(i*100+1,(i+1)*100);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
        //每隔50毫秒,轮询等待10个任务结束
        do {
            System.out.printf("Main:已经完成了多少个任务:%d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main Task %d:%s\n", i, result.isDone());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (executor.getCompletedTaskCount() < resultList.size());
        //所有任务都已经结束,综合计算结果
        int total = 0;
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer sum = null;
            try {
                sum = result.get();
                total = total + sum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("1-1000的总和" + total);
    }
}
