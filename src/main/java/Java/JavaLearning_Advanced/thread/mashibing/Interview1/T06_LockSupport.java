package Java.JavaLearning_Advanced.thread.mashibing.Interview1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-18 12:32
 */
public class T06_LockSupport {
    static class list {
        List<Object> list = new ArrayList<>();

        int size() {
            return list.size();
        }

        void add(Object o) {
            list.add(o);
        }
    }
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        // 观察线程
        list list = new list();

        t1 = new Thread(() -> {
            System.out.println("t2开始");
            while (list.size() != 5) {
                LockSupport.park();
            }
            System.out.println("t2结束");
            LockSupport.unpark(t2);
        });
        t2 = new Thread(() -> {
            System.out.println("t1开始");
            for (int i = 0; i < 10; i++) {
                list.add(new Object());
                System.out.println(list.size());
                if (list.size() == 5) {
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
            }
        });
        t1.start();
        t2.start();

    }
}
