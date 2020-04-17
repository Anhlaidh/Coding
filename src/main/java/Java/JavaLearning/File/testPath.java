package Java.JavaLearning.File;

import java.io.File;
import java.nio.file.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/19 0019 16:09
 */
public class testPath {
    public static void main(String[] args) {
        //Path和java.io.File基本类似
        //获取path方法一：./temp/abc.txt
        Path path = FileSystems.getDefault().getPath("./temp", "abc.txt");
        System.out.println(path.getNameCount());
        //获取path方法二，用File的toPath()方法获得Path对象
        File file = new File("./temp/abc.txt");
        Path pathOther = file.toPath();
        //0，说明这两个path是相等的
        System.out.println(path.compareTo(pathOther));
        //获得path的方法三
        Path path3 = Paths.get("./temp", "abc.txt");
        System.out.println(path3.toString());
        //合并两个path
        Path path4 = Paths.get("./temp");
        System.out.println("path4:" + path4.resolve("abc.txt"));
        if (Files.isReadable(path)) {
            System.err.println("it is readable");
        }
        else {
            System.err.println("it is not readable");
        }

    }
}
