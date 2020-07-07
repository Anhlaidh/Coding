package Java.Java_Final.Reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-07 19:32
 */
public class testNewInstance {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Object obj1 = Class.forName("Java.Java_Final.Reflect.A").newInstance();
        Method m = Class.forName("Java.Java_Final.Reflect.A").getMethod("hello");
        m.invoke(obj1);
        A obj2 = (A) Class.forName("Java.Java_Final.Reflect.A").newInstance();
        Constructor<A> constructor = A.class.getConstructor();
        A obj3 = constructor.newInstance();
        obj3.hello();

    }

}
