package Java.JavaLearning_Advanced.thread.message;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 20:55
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        TestTread3 testTread3 = new TestTread3();
        testTread3.start();

        Thread.sleep(1000);
        testTread3.flag = false;
        System.out.println("main thread is exiting");

    }

    private static class TestTread3 extends Thread {
        //        boolean flag = true;//子线程不会停止
        volatile boolean flag = true;//用volatile修饰的变量可以及时在各线程里面通知
        @Override
        public void run() {
            int i = 0;
            while (flag) {
                i++;
            }
            System.out.println("test thread is exiting");

        }
    }
}
