package Java.JavaLearning_Advanced.thread.mashibing.Interview2;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-18 13:49
 */
public class LockCollection {
    static class MyCollection<T> {
        Lock lock = new ReentrantLock();
        Condition consumer = lock.newCondition();
        Condition producer = lock.newCondition();
        int count = 0;
        int Max = 10;
        LinkedList<T> list = new LinkedList<>();

        void put(T i) {
            try {
                lock.lock();
                while (count == Max) {
                    producer.await();
                }
                list.add(i);
                count++;
                consumer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        T get() {
            T t = null;
            try {
                lock.lock();
                while (count == 0) {
                    consumer.await();
                }
                t = list.removeFirst();
                count--;
                producer.signalAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }return t;

        }

        int getCount() {
            return count;
        }

    }

    public static void main(String[] args) {
        MyCollection<String> c = new MyCollection<>();


        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    String s = Thread.currentThread().getName();
                    c.put(s);

                    System.out.printf("当前线程:%s,存入%s个,剩余:%d\n", Thread.currentThread().getName(), s, c.getCount());
                }

            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.printf("当前线程:%s,取出:%s,剩余:%d\n", Thread.currentThread().getName(), c.get(), c.getCount());
                }
            }).start();
        }
    }
}
