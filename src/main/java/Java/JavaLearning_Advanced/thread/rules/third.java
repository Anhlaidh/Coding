package Java.JavaLearning_Advanced.thread.rules;

/**
 * @Description:
 * 规则三：
 * 1.实现Runnable的对象必须包装在Thread类里面，才可以启动
 * 2. 不能直接对Runnable对象进行start方法
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 23:33
 */
public class third {
    public static void main(String[] args) throws InterruptedException {
//        new TestThread2().start();
        //runnable对象必须放在一个Thread类中才能运行
        TestThread2 tt = new TestThread2();
        Thread thread = new Thread(tt);
        thread.start();
        while (true) {
            System.out.println("main");
            Thread.sleep(1000);
//        }
        }

    }
}

class TestThread2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            //输出当前线程名
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}