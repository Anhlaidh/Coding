package Java.Java_Final.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-07 19:41
 */
public class getClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
//        get_Class();
//        getField();
//        getMethod();
//        getConstructor();
        getFather();
    }

    private static void getFather() {
        B b = new B();
        Class<? extends B> c = b.getClass();
        Class<?> superclass = c.getSuperclass();
        System.out.println(superclass.getName());
        Class<?>[] interfaces = c.getInterfaces();
        for (Class inter : interfaces) {
            System.out.println(inter.getName());

        }

    }

    private static void getConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        A obj = new A();
        Class<? extends A> c = obj.getClass();
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() > 0) {
                //有参构造
                A obj1 = (A) constructor.newInstance(100, "Tom");
                obj1.print();

            } else {
                //无参构造
                A obj2 = (A) constructor.newInstance();
                obj2.print();
            }
        }

    }

    private static void getMethod() throws InvocationTargetException, IllegalAccessException {
        A obj = new A();
        Class<? extends A> c = obj.getClass();
        //获取public方法包括父类和父接口
        Method[] ms = c.getMethods();
        for (Method m : ms) {
            if ("hello".equals(m.getName())) {
                m.invoke(obj, null);
            }
        }
        //获得该类的所有方法
        Method[] ms2 = c.getDeclaredMethods();
        for (Method m : ms2) {
            if ("getString".equals(m.getName())) {
                m.setAccessible(true);
                String result = (String)m.invoke(obj, "aaaaa");
                System.out.println(result);
            }
        }


    }

    private static void getField() throws IllegalAccessException {
        A obj = new A(20, "Tom");
        Class c = obj.getClass();
        //获取本类及父类所有的public字段
        Field[] fs = c.getFields();
        System.out.println(fs[0].getName()+":"+fs[0].get(obj));
        //获取本类所有声明字段
        Field[] fs2 = c.getDeclaredFields();
        for (Field f : fs2) {
            f.setAccessible(true);//允许访问私有变量
            System.out.println(f.getName() + ":" + f.get(obj));
        }


    }

    private static void get_Class() throws ClassNotFoundException {
        String s1 = "abc";
        Class c1 = s1.getClass();
        System.out.println(c1.getName());
        String s2 = "abc";
        Class<?> c2 = Class.forName("java.lang.String");
        System.out.println(c2.getName());
        String s3 = "abc";
        Class<String> c3 = String.class;
        System.out.println(c3.getName());
    }
}
