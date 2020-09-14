package Java.JavaLearning_Advanced.thread.Disruptor.v1;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.concurrent.Executors;

/**
 * @Description: translator
 * @author: Anhlaidh
 * @date: 2020-08-30 17:10
 */
public class Main02 {
    public static void main(String[] args) {
        LongEventFactory factory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, DaemonThreadFactory.INSTANCE);
        //守护线程
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        EventTranslator<LongEvent> translator1 = new EventTranslator<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence) {
                event.setValue(8888L);
            }
        };
        ringBuffer.publishEvent(translator1);
        EventTranslatorOneArg<LongEvent, Long> translatorOneArg = new EventTranslatorOneArg<LongEvent, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long arg0) {
                event.setValue(arg0);
            }
        };
        ringBuffer.publishEvent(translatorOneArg, 7777L);
        //one two three .... var args
        EventTranslatorVararg<LongEvent> translatorVararg = new EventTranslatorVararg<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Object... args) {
                long result = 0;
                for (Object o : args) {
                    long l = (long) o;
                    result += l;
                }
                event.setValue(result);
            }
        };
        ringBuffer.publishEvent(translatorVararg, 1000L, 2000L, 50000L);
    }
}
