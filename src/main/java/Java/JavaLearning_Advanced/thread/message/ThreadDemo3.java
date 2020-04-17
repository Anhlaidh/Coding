package Java.JavaLearning_Advanced.thread.message;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 21:16
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3).start();
        new Thread(testThread3).start();
        new Thread(testThread3).start();
        new Thread(testThread3).start();

    }

    private static class TestThread3 implements Runnable {
        private volatile int tickets = 100;

        @Override
        public void run() {
            while (tickets>0) {
                sale();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

        private synchronized void sale() {
            System.out.println(Thread.currentThread().getName() + " sale " + tickets--);
        }
    }
}
