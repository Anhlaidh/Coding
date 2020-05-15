package Java.JavaLearning_Advanced.thread.Quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-12 21:23
 */
public class Test {
    public static void main(String[] args) {
        try {
            //创建scheduler,调度器,核心组件
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //定义一个Trigger,触发条件类
            // 创建触发器
            Trigger trigger = newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(2)
                            .repeatForever())
                    .build();
            JobDetail job = JobBuilder.newJob(MyJob.class)
                    .withIdentity("test1", "group1")
                    .usingJobData("data", "jobData_data")
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
