package Java.JavaLearning.testException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 21:17
 */
public class MultipleCatch {
    public static void main(String[] args) {
        try {
            int a = 5/0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            System.out.println("Phrase 2 is over");
        }
    }
}
