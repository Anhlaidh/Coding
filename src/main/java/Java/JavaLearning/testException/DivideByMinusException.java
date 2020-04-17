package Java.JavaLearning.testException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 23:29
 */
public class DivideByMinusException extends Exception {
    int divisor;

    public int getDivisor() {
        return divisor;
    }

    public DivideByMinusException(String message, int divisor) {
        super(message);
        this.divisor = divisor;
    }
}
