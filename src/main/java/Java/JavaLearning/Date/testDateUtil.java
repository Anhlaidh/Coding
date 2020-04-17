package Java.JavaLearning.Date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/15 0015 21:50
 */
public class testDateUtil {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        //判断是否是闰年
        System.out.println("Year"+today.getYear()+"is Leap Year  "+today.isLeapYear());
        //今天和01/01/2015比较
        System.out.println("Today is before 01/01/2015 "+today.isBefore(LocalDate.of(2015,1,1)));
        //当前时分秒
        System.out.println("Current Time="+today.atTime(LocalTime.now()));
        //加减时间
        System.out.println("10days after today will be"+today.plusDays(10));
        System.out.println("3weeks after today will be"+today.plusWeeks(3));
        System.out.println("20months after today will be"+today.plusMonths(20));

        System.out.println("10days before today will be"+today.minusDays(10));
        System.out.println("3weeks before today will be"+today.minusWeeks(3));
        System.out.println("20months before today will be"+today.minusMonths(20));
        //调整时间
        System.out.println("First date of this month="+today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear=today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year ="+lastDayOfYear);
        //时间段计算
        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format="+period);
        System.out.println("Months remaining in the year ="+period.getMonths());


    }
}
