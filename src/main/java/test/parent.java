package test;

import java.util.function.Function;
import Java.Java_Final.Annotation.Single.SingleTest;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-13 14:14
 */
class Parent {

    // 静态变量
    public static String p_StaticField = "父类--静态变量";
    // 变量
    public String p_Field = "父类--变量";
    protected int i = 9;
    protected int j = 0;
    // 静态初始化块
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }
    // 初始化块
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }
    //构造器
    public Parent() {
        System.out.println("父类--构造器");
        System.out.println("i=" + i + ", j=" + j);
        j = 20;
    }
    //静态方法
    static void sPrint(){
        System.out.println("父类静态方法初始化");
    }
    //方法
    void Print(){
        System.out.println("父类方法初始化");
    }
}

class Sub extends Parent {
    // 静态变量
    public static String s_StaticField = "子类--静态变量";
    // 变量
    public String s_Field = "子类--变量";
    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }

    //初始化块
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }
    //构造器
    public Sub() {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }
    static void sPrint(){
        System.out.println("子类静态方法初始化");
    }
    //方法
    void Print(){
        System.out.println("子类方法初始化");
    }
    //程序入口
    public static void main(String[] args) {
        System.out.println("子类main方法");
        new Sub();
    }

}