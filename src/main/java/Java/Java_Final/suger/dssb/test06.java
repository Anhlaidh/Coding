package Java.Java_Final.suger.dssb;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-14 16:45
 */
public class test06 {
       static int result = 5;
    public static int fun() {
        try {
            result = result / 0;
            return result;
        } catch (Exception e) {
            System.out.println("Exception");
            result = -1;
            return result;
        } finally {
            result = 10;
            System.out.println("I am in finally");

        }
    }
    public static void main(String[] args) {
        int x = fun();
        System.out.println(x);

    }
}
