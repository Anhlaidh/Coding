package Java.JavaLearning.javaIO.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: 每个线程对应一个selector
 * 多线程情况下,该主机,该程序的并发客户端被分配到多个selector上
 * 注意,每个客户端只绑定到其中一个selector
 * 其实不会有交互问题
 * @author: Anhlaidh
 * @date: 2020-09-30 16:29
 */
public class SelectorThread implements Runnable {
    Selector selector = null;

    public SelectorThread() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //Loop
        while (true) {
            try {
                //阻塞 wakeup()
                // 1.select
                int nums = selector.select();
                //2. 处理selectKeys
                if (nums > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        // 复杂,接收客户端的过程(接受之后,要注册,多线程下,新的客户端,注册到哪里?)
                        if (key.isAcceptable()) {
                            acceptHandler(key);

                        } else if (key.isReadable()) {
                            readHandler(key);

                        } else if (key.isWritable()) {

                        }
                    }


                }
                //3.处理task

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readHandler(SelectionKey key) {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel client = (SocketChannel) key.channel();
        buffer.clear();
        while (true) {
            try {
                int code = client.read(buffer);
                if (code > 0) {
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();
                } else if (code == 0) {
                    break;

                } else {
                    System.out.println("client:" + client.getRemoteAddress() + " was closed");
                    key.cancel();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void acceptHandler(SelectionKey key) {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);

            //choose
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
