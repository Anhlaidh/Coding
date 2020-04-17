package Java.JavaLearning_Advanced.thread.product;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 23:10
 */
public class Producer implements Runnable {
    volatile int i = 0;
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        Random random = new Random();
        while (i <10) {
            i++;
            Product product = new Product(i ,"电话" + random.nextInt(100));
            storage.push(product);

        }
    }
}
