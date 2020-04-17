package Java.JavaLearning_Advanced.thread.message;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 20:32
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        new Thread(testThread1).start();
        new Thread(testThread1).start();
        new Thread(testThread1).start();
        new Thread(testThread1).start();
    }

    private static class TestThread1 implements Runnable {
        //        private int tickets = 100; 每个线程卖100张，没有共享
        private  int tickets = 4;  //static变量是共享的，所有的线程共享
        @Override
        public void run() {
            while (tickets>0) {
                System.out.println(Thread.currentThread().getName() + " is selling tickets" + tickets);
                tickets = tickets - 1;

            }
        }
    }
}
