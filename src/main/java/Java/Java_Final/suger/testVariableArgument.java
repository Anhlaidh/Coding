package Java.Java_Final.suger;

/**
 * @Description: 可变参数
 * @author: Anhlaidh
 * @date: 2020-07-05 21:46
 */
public class testVariableArgument {
    public static void main(String[] args) {
        print();
        print("aaa");
        print("aaa","bbb");
        print("aaa","bbb","ccc");

    }

    private static void print(String... args) {
        System.out.println(args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    //当只有一个参数时,本方法优先级更高
    private static void print(String s) {
        System.out.println("优先级高的方法");
    }

    //错误:一个方法不可以有多个可变参数
//    public static void print(String... args, int... irgs) {
//
//    }
    //调用语句,同时与两个带可变参数的方法匹配,则报错
//    private static void print(String s1, String... args) {
//
//    }
}
