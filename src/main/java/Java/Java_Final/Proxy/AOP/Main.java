package Java.Java_Final.Proxy.AOP;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-04 20:47
 */
public class Main {
    public static void initXml() {
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Main.initXml();

        Person action = new PersonImpl();
        ProxyHandler mh = new ProxyHandler(action);
        ClassLoader classLoader = Main.class.getClassLoader();
        Class<?> proxyClass = Proxy.getProxyClass(classLoader, new Class<?>[]{Person.class});
        Person proxy = (Person) proxyClass.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{mh});
        while (true) {
            proxy.eat();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}
