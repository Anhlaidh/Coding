package Java.JavaLearning.javaIO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/22 0022 21:22
 */
public class testBinWrite {
    public static void main(String[] args) {
        method_1();

    }

    public static void method_1() {
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("./temp/def.dat");
            dataOutputStream = new DataOutputStream(fileOutputStream);
            bufferedOutputStream = new BufferedOutputStream(dataOutputStream);

            dataOutputStream.writeUTF("a");
            dataOutputStream.writeInt(222);
            dataOutputStream.writeUTF("b");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
