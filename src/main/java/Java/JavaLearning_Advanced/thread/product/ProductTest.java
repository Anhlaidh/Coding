package Java.JavaLearning_Advanced.thread.product;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/30 0030 0:29
 */
public class ProductTest {
    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage();
        Consumer consumer = new Consumer(storage);
        Thread consumer1 = new Thread(consumer);
        consumer1.setName("消费者1");
        Thread consumer2 = new Thread(consumer);
         consumer2.setName("消费者2");
        Producer producer = new Producer(storage);
        Thread producer1 = new Thread(producer);
        producer1.setName("生产者1");
        Thread producer2 = new Thread(producer);
        producer2.setName("生产者1");
        producer1.start();
        producer2.start();
//        Thread.sleep(1000);
        consumer1.start();
        consumer2.start();
    }
}
