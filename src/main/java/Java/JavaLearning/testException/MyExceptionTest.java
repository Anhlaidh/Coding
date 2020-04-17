package Java.JavaLearning.testException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 23:23
 */
public class MyExceptionTest {
    public static void testException() throws MyException {
        throw new MyException("10001", "the reason of myException");
    }
    public static void main(String[] args) {
        try {
            MyExceptionTest.testException();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("code="+e.getReturnCode());
            System.out.println("message="+e.getReturnMsg());
        }
    }
}
