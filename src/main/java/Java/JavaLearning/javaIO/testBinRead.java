package Java.JavaLearning.javaIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/22 0022 21:33
 */
public class testBinRead {
    public static void main(String[] args) {
        method_2();
    }

    //try-resource
    public static void method_2() {
        try (DataInputStream dataInputStream = new DataInputStream( new BufferedInputStream(new FileInputStream("./temp/def.dat")))) {
            String a = dataInputStream.readUTF();
            int b = dataInputStream.readInt();
            String c = dataInputStream.readUTF();
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
