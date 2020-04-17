package Java.JavaLearning.Date;

import java.time.Instant;
import java.util.Date;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/15 0015 21:44
 */
public class testInstant {
    public static void main(String[] args) {
        //获取当前时间戳
        Instant timestamp = Instant.now();
        System.out.println("current Timestamp="+timestamp);
        //从毫秒数来创建
        // 时间戳
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time="+specificTime);
        Date date = Date.from(timestamp);
        System.out.println("current Date="+date);
    }
}
