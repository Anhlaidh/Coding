package Java.JavaLearning_Advanced.process;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 22:37
 */
public class ProcessDemo {
    public static void main(String[] args) {
        int a = 0;
        while (true) {

            System.out.println(a++);
            try {
                Thread.sleep(500);//睡眠5000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

}
