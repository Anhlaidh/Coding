package Java.JavaLearning_Advanced.thread.Disruptor.v1;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 18:14
 */
public class Main6_MultiConsumer {
    public static void main(String[] args) {
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE, ProducerType.MULTI, new BlockingWaitStrategy());
        LongEventHandler longEventHandler1 = new LongEventHandler();
        LongEventHandler longEventHandler2 = new LongEventHandler();
        // 多个消费者多个线程
        disruptor.handleEventsWith(longEventHandler1, longEventHandler2);
        disruptor.handleExceptionsFor(longEventHandler1).with(new ExceptionHandler<LongEvent>() {
            @Override
            public void handleEventException(Throwable ex, long sequence, LongEvent event) {

            }

            @Override
            public void handleOnStartException(Throwable ex) {

            }

            @Override
            public void handleOnShutdownException(Throwable ex) {

            }
        });
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
    }
}
