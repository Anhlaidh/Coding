package Java.JavaLearning_Advanced.thread.message;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 20:23
 */
public class ThreadDemo0 {
    public static void main(String[] args) {
        new TestThread0().start();
        new TestThread0().start();
        new TestThread0().start();
        new TestThread0().start();
    }

    private static class TestThread0 extends Thread {
//        private int tickets = 100; 每个线程卖100张，没有共享
        private static int tickets = 100;  //static变量是共享的，所有的线程共享
        @Override
        public void run() {
            while (tickets>0) {
                System.out.println(Thread.currentThread().getName() + " is selling tickets" + tickets);
                tickets = tickets - 1;

            }
        }
    }
}
