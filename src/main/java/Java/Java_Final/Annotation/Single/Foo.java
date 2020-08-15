package Java.Java_Final.Annotation.Single;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-05 16:44
 */
public class Foo {
    @SingleTest(1)
    public static void m1(int a) {
        System.out.println(a);
        if (a < 0) {
            throw new RuntimeException("Crash");
        }
    }

    @SingleTest(value = -2)
    public static void m2(int a) {
        System.out.println(a);
        if (a < 0) {
            throw new RuntimeException("Crash");
        }
    }

    public static void m2() {

    }
}
