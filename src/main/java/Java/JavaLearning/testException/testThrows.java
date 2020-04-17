package Java.JavaLearning.testException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 21:31
 */
public class testThrows {

    public static void main(String[] args) {
        try {
            int result = new Test().divide(3, 1);
            System.out.println("the 1st result is"+result);
        }catch (ArithmeticException ex){
            ex.printStackTrace();
        }
        int result = new Test().divide(3, 0);
        System.out.println("the 2nd result is"+result);
    }
}
class Test{
    public int divide(int x,int y) throws ArithmeticException{
        int result =x/y;
        return x/y;
    }
}