package Java.JavaLearning_Advanced.Generic;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 22:27
 */
public class Interval<T> {
    private T lower;
    private T upper;

    public Interval(T lower, T upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public static <T> Interval<T> getReverse(Interval<T> interval) {
        return new Interval<T>(interval.getUpper(), interval.getLower());
    }

    public T getLower() {
        return lower;
    }

    public void setLower(T lower) {
        this.lower = lower;
    }

    public T getUpper() {
        return upper;
    }

    public void setUpper(T upper) {
        this.upper = upper;
    }
}
