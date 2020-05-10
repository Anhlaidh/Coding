package Java.JavaLearning_Advanced.thread.Phaser;

import java.util.concurrent.Phaser;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-05-08 19:46
 */
public class PhaserExample {
    /**
     * 假设举行考试,总共三个答题,每次下发一道题目,等所有学生完成后再进行下一道
     * @param args
     */
    public static void main(String[] args) {
        int STUDENT_CNT = 5;
        Phaser phaser = new Phaser(STUDENT_CNT);
        for (int i = 0; i < STUDENT_CNT; i++) {
            new Thread(new Student(phaser)).start();
        }

    }

    private static class Student implements Runnable {
        private final Phaser phaser;
        public Student(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                doTesting(1);
                phaser.arriveAndAwaitAdvance();
                doTesting(2);
                phaser.arriveAndAwaitAdvance();
                doTesting(3);
                phaser.arriveAndAwaitAdvance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void doTesting(int i) throws InterruptedException {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始第" + i + "题");
            long thinkingTime = (long) (Math.random() * 1000);
            Thread.sleep(thinkingTime);
            System.out.printf("%s第%d到题答题结束\n",name,i);
        }
    }
}
