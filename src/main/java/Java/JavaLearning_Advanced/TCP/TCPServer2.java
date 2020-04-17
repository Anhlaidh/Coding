package Java.JavaLearning_Advanced.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 13:16
 */
public class TCPServer2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("来了一个client");
                new Thread(new Worker(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Worker implements Runnable{
        private Socket socket;
        public Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("服务人员已启动");
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(outputStream);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String strWord = bufferedReader.readLine();
                    System.out.println("client said:" + strWord + ":" + strWord.length());
                    if (strWord.equalsIgnoreCase("quit")) {
                        break;
                    }
                    String strEcho = strWord + "666";
                    System.out.println("server said:" + strWord + "--------->" + strEcho);
                    dos.writeBytes(strWord + "--------->" +strEcho+ System.getProperty("line.separator"));
                }
                bufferedReader.close();
                dos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
