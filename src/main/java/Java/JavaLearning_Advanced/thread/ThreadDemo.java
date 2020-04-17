package Java.JavaLearning_Advanced.thread;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 22:45
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        new TestTread1().start();
        while (true) {
            System.out.println("main thread is running");
            Thread.sleep(1000);
        }
    }
}
class TestTread1 extends Thread{
    public void run() {
        while (true) {
            System.out.println("testThread1 is running");
            try {
                Thread.sleep(1000);//睡眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
