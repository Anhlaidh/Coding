package Java.JavaLearning_Advanced.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Description: receive
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 0:23
 */
public class UdpRecv {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        System.out.println("UdpRecv：等待信息");
        socket.receive(packet);
        System.out.println("UdpRecv:已接受信息");
        String strRecv = new String(packet.getData(), 0, packet.getLength()) + "from" + packet.getAddress().getHostAddress()
                + ":" + packet.getPort();
        System.out.println(strRecv);
        String str = "nice to meet you!!";
        DatagramPacket packet1 = new DatagramPacket(str.getBytes(), str.length(), packet.getAddress(), packet.getPort());
        System.out.println("UdpRecv:即将发送信息！");
        socket.send(packet1);
        System.out.println("UdpRecv:已发送");

    }
}
