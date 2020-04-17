package Java.JavaLearning_Advanced.thread.Executor.example1;

import static java.lang.Math.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 23:57
 */
public class Task implements Runnable{
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Long duration = (long) (random() * 1000);
            System.out.printf("%s:Task %s:Doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s:Task %s:Finished on:%s\n",Thread.currentThread().getName(),name,Thread.currentThread().getName());


    }
}
