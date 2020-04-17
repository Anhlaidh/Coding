package Java.JavaLearning.Date;

import java.util.Calendar;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 11:28
 */
public class testCalendar {
    Calendar calendar = Calendar.getInstance();
     void test1(){
        int year = calendar.get(Calendar.YEAR);//获取年
        int month = calendar.get(Calendar.MONTH);//获取月
        int day = calendar.get(Calendar.DAY_OF_MONTH);//获取日
        int hour = calendar.get(Calendar.HOUR);//获取时
        int minute = calendar.get(Calendar.MINUTE);//获取分
        int second = calendar.get(Calendar.SECOND);//获取秒
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);//星期，英语国家星期从星期日开始计算
        System.out.println("现在是"+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分"+second+"秒---"+"星期"+(weekday-1));
    }
    void test2(){
         //同理换成下个月的今天calendar.add(Calendar.MONTH,1)
        calendar.add(Calendar.YEAR,1);
        //获取年
        int year = calendar.get(Calendar.YEAR);
        //获取月
        int month = calendar.get(Calendar.MONTH)+1;
        //获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("一年后的今天"+year+"年"+month+"月"+day+ "日");
    }
    void test3(){
         //假设6月的最后一天
        int currentMonth=6;
        //先求出7月份的第一天，实际中这里6为外部传进来的currentMonth变量
        calendar.set(calendar.get(Calendar.YEAR),currentMonth,1);
        calendar.add(Calendar.DATE,-1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("六月份的最后一天是"+day+"号");

    }
    void test4(){
         calendar.set(Calendar.YEAR,2000);
        System.out.println("现在是"+calendar.get(Calendar.YEAR)+"年");
        calendar.set(2018,7,8);
        //获取年
        int year = calendar.get(Calendar.YEAR);
        //获取月
        int month = calendar.get(Calendar.MONTH)+1;
        //获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("现在是"+year+"年"+month+"月"+day+ "日");

    }
    void test5(){
         //add方法
         calendar.set(2018,7,8);
         calendar.add(Calendar.DAY_OF_MONTH,-8);
        //获取年
        int year = calendar.get(Calendar.YEAR);
        //获取月
        int month = calendar.get(Calendar.MONTH)+1;
        //获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("2018.8.8用add方法减少8天，现在是"+year+"年"+month+"月"+day+ "日");


    }
    void test6(){
         //roll方法，不动月份
        calendar.set(2018,7,8);
        calendar.roll(Calendar.DAY_OF_MONTH,-8);
        //获取年
        int year = calendar.get(Calendar.YEAR);
        //获取月
        int month = calendar.get(Calendar.MONTH)+1;
        //获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("2018.8.8用roll方法减少8天，现在是"+year+"年"+month+"月"+day+ "日");
    }
    public static void main(String[] args) {
         testCalendar testCalendar = new testCalendar();
         testCalendar.test1();
        System.out.println("===============================");
         testCalendar.test2();
        System.out.println("===============================");
        testCalendar.test3();
        System.out.println("===============================");
        testCalendar.test4();
        System.out.println("===============================");
        testCalendar.test5();
        System.out.println("===============================");
        testCalendar.test6();

    }
}
