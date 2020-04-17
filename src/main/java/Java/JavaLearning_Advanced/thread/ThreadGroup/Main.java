package Java.JavaLearning_Advanced.thread.ThreadGroup;


import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 22:51
 */
public class Main {
    public static void main(String[] args) {
        //创建线程组
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        //创建一个任务,10个线程完成
        Searcher searcherTask = new Searcher(result);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searcherTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=======分割线0=========");
        //查看线程组消息
        System.out.printf("active线程数量:%d\n", threadGroup.activeCount());
        System.out.println("线程组信息明细");
        threadGroup.list();
        System.out.println();
        //遍历线程组
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        System.out.println("=======分割线1=========");
        //Wait for the finalization of the Thread
        waitFinish(threadGroup);
        //interrupt all the Thread objects to the ThreadGroup
        threadGroup.interrupt();

    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
