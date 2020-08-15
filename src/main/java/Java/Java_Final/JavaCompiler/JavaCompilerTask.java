package Java.Java_Final.JavaCompiler;

import javax.tools.*;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-04 14:46
 */
public class JavaCompilerTask {
    public static void main(String[] args) {
        compilerJavaFromString();
//        System.out.println("hello world");
    }

    private static void compilerJavaFromString() {
        StringBuffer stringBuffer = new StringBuffer();
        String className = "Hello";
        stringBuffer.append("public class " + className + "{");
        stringBuffer.append(" public static void main(String[] args) {");
        stringBuffer.append(" System.out.println(\"hello world\");\n");
        stringBuffer.append("}\n");
        stringBuffer.append("}\n");


        Class<?> c = compiler(className, stringBuffer.toString());
        try {
            //生成对象
            Object obj = c.newInstance();
            Method m = c.getMethod("main", String[].class);
            m.invoke(obj, new Object[]{new String[]{}});

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private static Class<?> compiler(String className, String javaCode) {
        JavaSourceFromString srcObject = new JavaSourceFromString(className, javaCode);
        System.out.println(srcObject.getCode());
        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(srcObject);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, Charset.defaultCharset());
        DiagnosticCollector<JavaFileObject> diagnosticCollector = new DiagnosticCollector<>();
        //设置编译的输出目录,并包装在options中
        String flag = "-d";
        String outDir = "";
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("");
            File classpath = new File(resource.toURI());
            outDir = classpath.getAbsolutePath() + File.separator;
            System.out.println(outDir);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Iterable<String> options = Arrays.asList(flag, outDir);
        /**
         * JavaCompiler.getTask方法:以future的任务形式(多线程)来执行编译任务
         * 第一个参数:额外输出流,null表示默认使用System.err
         * 第二个参数:文件管理器,null表示编译器默认方法来报告诊断信息
         * 第三个参数:诊断监听器,null表示使用编译器默认方法来报告诊断信息
         * 第四个参数:编译器参数,null表示无参数
         * 第五个参数:需要经过annotation处理的类名,null表示没有类需要annotation
         * 第六个参数,待编译的类
         */
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticCollector, options, null, fileObjects);
        //等待编译结束
        boolean result = task.call();
        if (result == true) {

            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            for (Diagnostic diagnostic : diagnosticCollector.getDiagnostics()) {
                System.out.println("Error on line:" + diagnostic.getLineNumber() + ";URI" + diagnostic.getSource().toString());
            }

        }
        return null;
    }

}
