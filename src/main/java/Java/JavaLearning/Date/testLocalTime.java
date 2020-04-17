package Java.JavaLearning.Date;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/15 0015 21:12
 */
public class testLocalTime {
    public static void main(String[] args) {
        //当前时分秒 纳秒
        LocalTime time = LocalTime.now();
        System.out.println("Current Time=" + time);
        //根据时分秒
        LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
        System.out.println("specificTime of Day=" + specificTime);
        //错误的时间参数
//        LocalTime invalidTime = LocalTime.of(25,20);
//        上海时间
        LocalTime timeSH = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("Current Time in Sh =" + timeSH);
        //一天当中第几秒
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time= "+specificSecondTime);

    }

}
