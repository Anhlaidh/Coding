package Java.JavaLearning_Advanced.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 11:59
 */
public class TcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);//驻守在8001端口
            Socket socket = serverSocket.accept();//阻塞，等到有客户端链接上来
            System.out.println("welcome to the java world");
            InputStream inputStream = socket.getInputStream();//有人连上来，打开输入流
            OutputStream outputStream = socket.getOutputStream(); //打开输入流
            //同一个通道，服务端的输出流就是客户端的输入流，服务端的输入流就是客户端的输出流
            outputStream.write("Hello,Client".getBytes());//输出一句话给客户端
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //从客户端读取一句话
            System.out.println("Client said:" + bufferedReader.readLine());

            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
