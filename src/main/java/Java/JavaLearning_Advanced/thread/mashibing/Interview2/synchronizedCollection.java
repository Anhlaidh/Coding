package Java.JavaLearning_Advanced.thread.mashibing.Interview2;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 写一个固定容量的同步容器, 拥有put和get方法, 以及getCount方法,
 * 能够支持2个生产者线程和10个消费者线程的的阻塞调用
 * @author: Anhlaidh
 * @date: 2020-08-18 12:50
 */
public class synchronizedCollection {

    static class MyCollection<T> {
        int count;
        int Max = 10;
        LinkedList<T> list = new LinkedList<>();

        synchronized void put(T i) {
            while (count == Max) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(i);
            ++count;
            this.notifyAll();
        }

        synchronized T get() {
            while (count == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = list.removeFirst();
            count--;
            this.notifyAll();
            return t;
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
