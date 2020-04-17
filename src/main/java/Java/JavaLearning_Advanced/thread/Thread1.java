package Java.JavaLearning_Advanced.thread;

/**
 * @Description:
 * Thread方式：
 *   a+=1;类来创建线程
 *  通过start方法来启动线程的run方法
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 22:54
 */
public class Thread1 extends Thread {
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new Thread1().start();
    }

}
