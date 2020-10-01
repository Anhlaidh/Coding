package Java.JavaLearning.javaIO.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-30 17:43
 */
public class SelectorThreadGroup {
    SelectorThread[] sts;
    ServerSocketChannel server = null;
    AtomicInteger xid = new AtomicInteger(0);

    public SelectorThreadGroup(int nums) {
        sts = new SelectorThread[nums];
        for (int i = 0; i < nums; i++) {
            sts[i] = new SelectorThread();
            new Thread(sts[i]).start();
        }
    }

    public void bind(int port) {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            nextSelector(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //注册到哪个selector上
    }
    //无论serverSocket socket 都复用这个方法

    private void nextSelector(Channel c) {
        SelectorThread st = next();
        //重点:c 有可能是server 有可能是client

    }

    private SelectorThread next() {
        int index = xid.incrementAndGet() % sts.length;
        return sts[index];
    }
}
