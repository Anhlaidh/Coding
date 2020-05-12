package Java.JavaLearning_Advanced.thread.Timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-10 17:42
 */
public class TimerTest {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        System.out.println("当前时间:" + new Date().toLocaleString());
        //当前时间一秒后,每两秒执行一次
        timer.schedule(myTask,1000,2000);
        Thread.sleep(10000);
        myTask.cancel();//取消当前任务
        System.out.println("==============");
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, now.get(Calendar.SECOND) + 3);
        Date runDate = now.getTime();
        MyTask2 myTask2 = new MyTask2();
        timer.scheduleAtFixedRate(myTask2,runDate,3000);
    }

    private static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了!时间为:"+new Date());
        }

    }

    private static class MyTask2 extends TimerTask{
        @Override
        public void run() {
            System.out.println("运行了!时间为:"+new Date());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
