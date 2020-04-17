package Java.JavaLearning_Advanced.thread.rules;

/**
 * @Description:
 * 规则二：
 * 1. main线程可能早于子线程结束
 * 2. main线程和子线程都结束了，整个程序才算终止
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 23:06
 */
public class second {
    public static void main(String[] args) throws InterruptedException {
        new TestThread1().start();
//        while (true) {
//            System.out.println("main");
//            Thread.sleep(10);
//        }
    }

}

class TestThread1 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("testThread1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
