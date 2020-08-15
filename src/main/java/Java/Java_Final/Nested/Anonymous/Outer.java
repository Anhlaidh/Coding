package Java.Java_Final.Nested.Anonymous;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-06 19:08
 */
public class Outer {
    public void f1() {
        String name = "def";
        Runnable r = new Runnable() {
            public final static int a = 5;
            //            public static int b = 1;
//            匿名内部类不能定义静态变量,除非是常量
            String name = "aaa";

            @Override
            public void run() {
                System.out.println("hello" + name);
                //屏蔽外部方法的临时变量
            }

//            public static void f2() {
//             静态方法不能再匿名内部类中定义
//            }

        };
        new Thread(r).start();
        System.out.println(r.getClass().getName());

    }

    public static void main(String[] args) {
        new Outer().f1();
    }
}
