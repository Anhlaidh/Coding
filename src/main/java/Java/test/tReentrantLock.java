package Java.test;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-19 14:45
 */
public class tReentrantLock {
    static class myCollection<T>{
        ReentrantLock lock = new ReentrantLock();
        LinkedList<T> list = new LinkedList<>();
        Condition consumer = lock.newCondition();
        Condition producer = lock.newCondition();

        int count;
        int Max = 10;

        public myCollection(int max) {
            Max = max;
        }

        void push(T t) {
            try {
                lock.lock();
                while (count == Max) {
                    producer.await();
                }
                count++;
                list.add(t);
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
                count--;
                t = list.removeFirst();
                producer.signalAll();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            finally {
                lock.unlock();

                return t;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        myCollection<String> collection = new myCollection<>(10);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    String name = Thread.currentThread().getName();
                    collection.push(name + "的产品");
                    System.out.println(name + "装入");
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
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "取出" + collection.get());
                }
            }).start();

        }
    }
}
