package Java.JavaLearning_Advanced.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description: D:\\aaa.txt
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 11:47
 */
public class TcpClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getByName("192.168.1.111"), 9999 );
            // 同一个通道，服务端输出流就是客户端的输入流，服务端的输入流，就是客户端的输出流
            InputStream inputStream = socket.getInputStream();//开启通道的输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream outputStream = socket.getOutputStream();//开启通道的输出流
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
            dataOutputStream.writeUTF("aaa.txt");
            while (true) {
                String strWord = brKey.readLine();
                if (strWord.equalsIgnoreCase("quit")) {
                    break;
                } else {
                    System.out.println("i want to sent "+strWord);
//                    outputStream.write(strWord.getBytes(), 0, strWord.length());//可以这么写
                    // +System.getProperty("line.separator")
                    dataOutputStream.writeBytes(strWord);

//                    System.out.println("server said"+bufferedReader.readLine());

                }
            }
            dataOutputStream.close();
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
