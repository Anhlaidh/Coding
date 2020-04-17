package Java.JavaLearning.File;

import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/19 0019 15:50
 */
public class testFile {
    public static void main(String[] args) {
        File d = new File("./temp");
        if (!d.exists()) {
            d.mkdir();
        }
        System.out.println("Is d directory" + d.isDirectory());
        //创建文件
        File f = new File("./temp/abc.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();//创建abc.txt
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //输出文件相关属性
        System.out.println("Is f file?" + f.isFile());
        System.out.println("Name:" + f.getName());
        System.out.println("Parent" + f.getParent());
        System.out.println("Path:" + f.getPath());
        System.out.println("Size:" + f.length() + "bytes");
        System.out.println("Last modified time" + f.lastModified() + "ms");
        //遍历d目录下的所有文件信息
        System.out.println("list files in d directory");
        File[] fs = d.listFiles();//列出d目录下的所有子文件，不包括子目录下的文件
        for (File f1 : fs) {
            System.out.println(f1.getPath());
        }
//        f.delete();
//        d.delete();
    }
}
