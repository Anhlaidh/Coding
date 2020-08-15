package Java.Java_Final.JavaCompiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-04 14:30
 */
public class SimpleJavaCompiler {
    public static void main(String[] args) {
//        successCompile();

        failCompile();
    }

    private static void failCompile() {
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, err, "./aaa.java");
        if (0 == result) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
            System.out.println(new String(err.toByteArray(), Charset.defaultCharset()) );
        }
    }


    private static void successCompile() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        /**
         * 第一个参数:输入流,null表示默认使用system.in
         * 第二个参数:输出流,null标识默认使用system.out
         * 第三个参数:错误流,null标识默认使用system.err
         * 第四个参数:String...需要编译的文件名
         * 返回值:0表示成功,其他错误
         */
        int result = compiler.run(null, null, null, "G:\\Coding\\src\\main\\java\\Java\\Java_Final\\API\\hello1.java","G:\\Coding\\src\\main\\java\\Java\\Java_Final\\API\\hello2.java");

        System.out.println(0 == result ? "Success" : "Fail");
    }
}
