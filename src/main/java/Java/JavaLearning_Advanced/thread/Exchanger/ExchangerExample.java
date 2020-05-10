package Java.JavaLearning_Advanced.thread.Exchanger;

import java.util.Scanner;
import java.util.concurrent.Exchanger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-10 17:16
 */
public class ExchangerExample {
    /**
     * 通过Exchanger实现学生成绩查询,简单线程间的数据交换
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<String>();
        BackgroundWorker worker = new BackgroundWorker(exchanger);
        new Thread(worker).start();
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("输出要查询的的属性学生姓名:");
            String input = reader.nextLine().trim();
            exchanger.exchange(input);
            String value = exchanger.exchange(null);
            if ("exit".equals(value)) {
                break;
            }
            System.out.println("查询结果" + value);

        }
        reader.close();

    }

    private static class BackgroundWorker implements Runnable{
        final Exchanger<String> exchanger;

        public BackgroundWorker(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String item = exchanger.exchange(null);
                    switch (item) {
                        case "zhangsan":
                            exchanger.exchange("90");
                            break;
                        case "lisi":
                            exchanger.exchange("80");
                            break;
                        case "wangwu":
                            exchanger.exchange("70");
                            break;
                        case "exit":
                            exchanger.exchange("exit");
                        default:
                            exchanger.exchange("none");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }

        }
    }
}
