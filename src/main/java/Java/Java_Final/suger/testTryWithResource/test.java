package Java.Java_Final.suger.testTryWithResource;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-07 16:58
 */
public class test {
    public static void main(String[] args) {
        try (MyConnection connection = new MyConnection()) {
            connection.sendData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
class MyConnection implements AutoCloseable {
    public void sendData() throws Exception {
        System.out.println("Send Data...");
    }
    @Override
    public void close() throws Exception {
        System.out.println("Close...");
    }
}