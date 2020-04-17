package Java.JavaLearning_Advanced.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description: send
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 0:24
 */
public class UdpSend {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        String str = "hi ,im a mini robot";
        DatagramPacket packet = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("127.0.0.1"), 3000);
        System.out.println("UdpSend:我要发送信息了");
        socket.send(packet);
        System.out.println("UdpSend: 发送完毕");
        Thread.sleep(1000);
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, 1024);
        System.out.println("UdpSend：我在等待信息");
        socket.receive(packet1);
        System.out.println("UdpSend：已收到信息");
        String str2 = new String(packet1.getData(), 0, packet1.getLength())+"from"+packet1.getAddress().getHostAddress()
                +":"+packet1.getPort();
        System.out.println(str2);
    }
}
