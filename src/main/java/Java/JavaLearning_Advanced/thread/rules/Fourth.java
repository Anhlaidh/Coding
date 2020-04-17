package Java.JavaLearning_Advanced.thread.rules;

/**
 * @Description:
 * 规则四：
 * 1. 一个线程对象不能多次start，多次start将报异常
 * 2. 多个线程对象都start后，哪一个先执行，完全由JVM/操作系统来主导，程序员无法指定
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 23:39
 */
public class Fourth {
    public static void main(String[] args) {
        TestThread4 t1 = new TestThread4();
        t1.start();
//        t1.start();
        TestThread4 t2 = new TestThread4();
        t2.start();
    }
}

class TestThread4 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
