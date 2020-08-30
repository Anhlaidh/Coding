package Java.JavaLearning_Advanced.thread.mashibing.Interview1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-18 12:29
 */
public class T05_CountDownLatch {
    static class list {
        List<Object> list = new ArrayList<>();
        int size() {
            return list.size();
        }

        void add(Object o) {
            list.add(o);
        }
    }

    public static void main(String[] args) {
        list list = new list();
        //观察线程
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2开始");
            try {
                latch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2结束");
            latch2.countDown();

        }).start();

        //添加线程
        new Thread(() -> {
            System.out.println("t1开始");
            for (int i = 0; i < 10; i++) {
                list.add(new Object());
                System.out.println(i);
                if (i == 5) {
                    latch1.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t1结束");
        }).start();
    }
}