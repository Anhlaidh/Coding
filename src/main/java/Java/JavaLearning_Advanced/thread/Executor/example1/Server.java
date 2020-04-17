package Java.JavaLearning_Advanced.thread.Executor.example1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 23:55
 */
public class Server {
    //线程池
    private ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool(5);可以指定线程数量
    }

    //向线程池提交任务
    public void submitTask(Task task) {
        System.out.print("Server: A new task has arrived \n");
        executor.execute(task);//执行,无返回值
        System.out.printf("Server:Pool Size:%d\n", executor.getPoolSize());
        System.out.printf("Server:Active Count:%d\n", executor.getActiveCount());
        System.out.printf("Server:Completed Tasked:%d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();

    }
}
