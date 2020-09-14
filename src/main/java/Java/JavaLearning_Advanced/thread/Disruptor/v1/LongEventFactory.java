package Java.JavaLearning_Advanced.thread.Disruptor.v1;

import com.lmax.disruptor.EventFactory;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 16:59
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
