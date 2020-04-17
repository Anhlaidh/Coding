package Java.JavaLearning.testException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 23:33
 */
public class Student {
    public int divide(int x, int y) {
        return x/y;
    }
    public int divide2(int x, int y) {
        int result;
        try {
            result = x / y;
            System.out.println("result is" + result);
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return x/y;
    }
    //ArithmeticException is a unchecked exception,编译器可以不管
    public int divide3(int x, int y) throws ArithmeticException{
        return x/y;
    }
    public int divide4(int x, int y) {
        //编译器不报错
        return divide3(x,y);
    }
    public int divide5(int x, int y) throws DivideByMinusException {
        try {
            if (y < 0) {
                throw new DivideByMinusException("The divisor is negative", y);
            }
        } catch (ArithmeticException ex) {
            //异常类型不匹配，继续往外抛，谁调用谁负责
            ex.printStackTrace();
            return 0;
        }
        return x/y;
    }
}
