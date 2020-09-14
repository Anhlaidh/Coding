package Java.JavaLearning_Advanced.thread.Disruptor.v1;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 16:58
 */
public class LongEvent {
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }
}
