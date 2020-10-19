package Java.JavaLearning_Advanced.TCP.testRoom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 13:25
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8001);
        while (true) {
            new Thread(new Worker(serverSocket.accept())).start();

        }
    }

    private static class Worker implements Runnable {
        private Socket socket;
        public Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try {
                System.out.println(socket.getChannel()+"连接至服务器");
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream out = new DataOutputStream(outputStream);
                while (true) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
