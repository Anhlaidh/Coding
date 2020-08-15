package Java.Java_Final.Proxy.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-04 20:38
 */
public class ProxyHandler implements InvocationHandler {
    static String beforeMethod = "washHand";
    static String afterMethod = "";
    private Person receiveObject;

    public ProxyHandler(Person receiveObject) {
        this.receiveObject = receiveObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //处理before
        if (beforeMethod != null && beforeMethod.length() > 0) {
            ClassLoader classLoader = ProxyHandler.class.getClassLoader();
            Class<?> c = classLoader.loadClass(receiveObject.getClass().getName());
            Method m = c.getMethod(beforeMethod);
            Object object = c.newInstance();
            m.invoke(object);
        }
        //处理目标方法
        Object result = method.invoke(receiveObject, args);
        //处理after
        if (afterMethod != null && afterMethod.length() > 0) {
            ClassLoader classLoader = ProxyHandler.class.getClassLoader();
            Class<?> c = classLoader.loadClass(receiveObject.getClass().getName());
            Method m = c.getMethod(afterMethod);
            Object object = c.newInstance();
            m.invoke(object);
        }
        return result;
    }
}
