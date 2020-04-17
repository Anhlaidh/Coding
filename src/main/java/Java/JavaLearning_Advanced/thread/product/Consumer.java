package Java.JavaLearning_Advanced.thread.product;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/30 0030 0:27
 */
public class Consumer implements Runnable{
    int i = 0;
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        while (i < 10) {
            i++;
            storage.pop();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
