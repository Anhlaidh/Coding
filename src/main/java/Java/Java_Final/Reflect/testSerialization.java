package Java.Java_Final.Reflect;

import java.io.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-07 18:05
 */
public class testSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A obj1 = new A();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(obj1);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        A obj2 = (A) in.readObject();
        in.close();
        obj2.hello();
    }

}

