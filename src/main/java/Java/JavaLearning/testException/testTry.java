package Java.JavaLearning.testException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 21:10
 */
public class testTry {
    public static void main(String[] args) {
        //无异常
        try {
            int a= 5/2;
            System.out.println("a is"+a);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("Phrase 1 is over");
        }
        //try中有异常
        try {
            int a= 5/0;
            System.out.println("a is"+a);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("Phrase 2 is over");
        }
        //catch 中有异常
        try {
            int a= 5/0;
            System.out.println("a is"+a);
        } catch (Exception ex) {
            ex.printStackTrace();
            int a = 5/0;
        }
        finally {
            System.out.println("Phrase 3 is over");
        }
    }
}
