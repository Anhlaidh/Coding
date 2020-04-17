package Java.JavaLearning_Advanced.thread.Interrupt;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 21:48
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();

        //让线程运行一会儿后终端
        Thread.sleep(2000);
        t1.interrupt();
        t2.flag = false;
        System.out.println("main thread is exiting");
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            //判断标志，当本线程被别人interrupt后，JVM会被本线程设置interrupted标记
            while (!interrupted()) {
                System.out.println("test thread1 is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }
            System.out.println("test thread1 is exiting");
        }
    }

    static class Thread2 extends Thread {
        public volatile boolean flag = true;

        @Override
        public void run() {
            //判断标志，当本线程被别人interrupt后，JVM会被本线程设置interrupted标记
            while (flag) {
                System.out.println("test thread2 is running ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test2 is exiting");
            }
        }
    }
}
