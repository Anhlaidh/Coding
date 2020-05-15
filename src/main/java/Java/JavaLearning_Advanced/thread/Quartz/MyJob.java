package Java.JavaLearning_Advanced.thread.Quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-12 21:20
 */
class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail detail = jobExecutionContext.getJobDetail();
        String name = detail.getKey().getName();
        String group = detail.getKey().getGroup();
        System.out.println("Group:"+group+"Name: " + name + "at" + new Date());
    }
}