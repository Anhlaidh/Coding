package Java.JavaLearning.javaIO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/22 0022 19:43
 */
public class testWrite {
    public static void main(String[] args) {
        method_1();
//        method_2();

    }

    public static void method_1() {
        FileOutputStream fileOutputStream = null;//节点类，负责写字节
        OutputStreamWriter outputStreamWriter = null;//转化类，负责字符到字节的转化
        BufferedWriter bufferedWriter = null;//装饰类，负责写字符到缓存区
        //三者关系bufferedWriter(OutputStreamWriter(FIleOutputStream)))

        try {
            fileOutputStream = new FileOutputStream("./temp/abc.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
//            bufferedReader = new BufferedReader(new OutputStreamWriter(new FileOutputStream("./temp.abc")));
            //一句话的写法
            outputStreamWriter.write("我们是");//TODO 存疑 javaIO可用outputStreamWrite来输出？
            bufferedWriter.newLine();
            bufferedWriter.write("method_1");
            bufferedWriter.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();//关闭最后一个，会将所有的底层流全部关闭
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void method_2() {
        //try-resource语句,自动关闭资源
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./temp/abc.txt")))) {
            bufferedWriter.write("我们是");
            bufferedWriter.newLine();
            bufferedWriter.write("method_2");
            bufferedWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
