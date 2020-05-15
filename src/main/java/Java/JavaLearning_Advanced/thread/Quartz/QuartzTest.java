package Java.JavaLearning_Advanced.thread.Quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-12 20:41
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
                    .startNow()//一旦加入scheduler,立即生效
                    .withSchedule(simpleSchedule()//使用SimpleTrigger
                            .withIntervalInSeconds(2)//每隔两秒执行一次
                            .repeatForever())//一直执行
                    .build();
            //定义一个JobDetail
            JobDetail job = newJob(MyJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("name", "quartz")
                    .build();
            //加入这个调度
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
            //运行一段时间后关闭
            Thread.sleep(100000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
