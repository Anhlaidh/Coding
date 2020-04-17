package Java.JavaLearning.Number;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/12 0012 23:14
 */
public class testRandom {
    public static void main(String[] args) {
        //第一种方法，采用Random类随机生成再int范围内的随机数
        Random rd = new Random();
        System.out.println(rd.nextInt());
        System.out.println(rd.nextInt(100));
        System.out.println(rd.nextLong());
        System.out.println("===================");
        //第二种，生成一个范围内的随机数，例如0到10之间的随机数
        System.out.println(Math.random()*10);
        System.out.println("===================");
        //JDK8新增方法
        rd.ints();//返回无限个int类型范围内的横竖
        int[] arr = rd.ints(10).toArray();//生成10个int范围类的个数
        for (int a:arr) System.out.println(a);
        arr = rd.ints(5,10,15).toArray();//5个10到15的随机数
        for (int a:arr) System.out.println(a);
        arr = rd.ints(10).limit(5).toArray();//limit表示限制只要10个，等价于random.ints(10)
        for (int a:arr) System.out.println(a);


    }
}
