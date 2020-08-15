package Java.Java_Final.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-04 16:03
 */
public class ProxyHandler implements InvocationHandler {
    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    //此函数在代理对象调用任何一个方法时都会被调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println("===before===");
        //定义预处理的工作,当然也可以根据method的不同进行不同的预处理工作
        Object result = method.invoke(subject, args);
        System.out.println("===after===");
        return result;
    }
}
