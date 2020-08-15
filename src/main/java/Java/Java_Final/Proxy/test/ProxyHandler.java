package Java.Java_Final.Proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-04 18:03
 */
@SuppressWarnings("ALL")
public class ProxyHandler implements InvocationHandler {
    private Cook cook;

    public ProxyHandler(Cook cook) {
        this.cook = cook;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy类型" + proxy.getClass().getName());
        System.out.println("调用方法" + method + ";参数为" + Arrays.deepToString(args));
        Object result = method.invoke(cook, args);
        return result;
    }
}
