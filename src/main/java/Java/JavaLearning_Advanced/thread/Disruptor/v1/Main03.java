package Java.JavaLearning_Advanced.thread.Disruptor.v1;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.io.IOException;

/**
 * @Description: lambda
 * @author: Anhlaidh
 * @date: 2020-08-30 17:20
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);
        disruptor.handleEventsWith(((event, sequence, endOfBatch) -> System.out.println("Event:" + event)));
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent((event, sequence, l) -> event.setValue(l), 1000L);
        System.in.read();

    }
}
