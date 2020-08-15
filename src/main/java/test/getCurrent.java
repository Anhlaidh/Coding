package test;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-14 18:18
 */
public class getCurrent {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis()+86400000 );
        }
    }
}
