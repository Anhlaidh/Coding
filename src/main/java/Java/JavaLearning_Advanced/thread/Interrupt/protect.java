package Java.JavaLearning_Advanced.thread.Interrupt;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 22:19
 */
public class protect {
    public static void main(String[] args) throws InterruptedException {
        Thread3 t = new Thread3();
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
        System.out.println("main thread is exiting");

    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running");
        }
    }
}
