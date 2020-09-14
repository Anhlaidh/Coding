package Java.JVM;

import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-07 18:07
 */
class T0100_ByteCode01 {
    private static int b = 100;
    public T0100_ByteCode01(String val) {
        System.out.println(val+b);
    }

     {
         System.out.println("bbbb");
         b += 100;

    }

    public T0100_ByteCode01() {
        System.out.println("无参");
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T0100_ByteCode01 a = new T0100_ByteCode01("a");
        T0100_ByteCode01 b;
        Class<?> byteCode01 = Class.forName("Java.JVM.T0100_ByteCode01");
        T0100_ByteCode01 o;
        Class<?> clazz = a.getClass().getClassLoader().loadClass("Java.JVM.T0100_ByteCode01");
        Class<?>[] parameterTypes = clazz.getConstructor().getParameterTypes();

    }


}
