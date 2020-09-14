package Java.JavaLearning_Advanced.thread.Disruptor.v1;

import com.lmax.disruptor.EventHandler;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 17:00
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    static long count = 0;

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        count++;
        System.out.println(event);
    }
}
