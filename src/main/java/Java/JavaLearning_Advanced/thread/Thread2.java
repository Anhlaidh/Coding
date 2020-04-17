package Java.JavaLearning_Advanced.thread;

/**
 * @Description:
 * Runnable方式
 *  可以通过实现Runnable接口来创建线程
 * 实现Runnable的对象必须包装在Thread类里面，才可以启动
 *  通过start方法来启动线程的run方法
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 22:56
 */
public class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new Thread(new Thread2()).start();
    }

}
