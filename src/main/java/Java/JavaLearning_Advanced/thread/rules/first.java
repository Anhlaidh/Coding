package Java.JavaLearning_Advanced.thread.rules;

/**
 * @Description:
 *  规则一：
 *  1.调用run方法来启动run方法，将会是串行运行
 *  2. 调用start方法，来启动run方法，将会是并行运行（多线程运行）
 *
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 22:59
 */

public class first {
    public static void main(String[] args) throws InterruptedException {
        new TestThread0().run();
        while (true) {
            System.out.println("main");
            Thread.sleep(10);
        }
    }

}

class TestThread0 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("testThread0");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
