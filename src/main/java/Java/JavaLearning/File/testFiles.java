package Java.JavaLearning.File;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Date;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/19 0019 16:36
 */
public class testFiles {
    public static void main(String[] args) {
        moveFile();
        fileAttributes();
        createDirectory();
    }

    private static void createDirectory() {
        Path path = Paths.get("./temp/test");
        //path.resolve("a.java")
        //创建文件  Files.createFile(path)
        //创建目录  Files.createDirectory(path)
        //遍历：for each
        //过滤器过滤文件名以什么结尾
//        DirectoryStream<Path> pathFilter = Files.newDirectoryStream(path, "*.{java,txt}");
//        for (Path p : pathFilter) {
//            System.out.println(p.getFileName());
//        }
        //try catch

    }

    private static void fileAttributes() {
        Path path = Paths.get("./temp");
        //1
        System.out.println(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));
        //2
        try {
            //获取文件的基础属性
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(attributes.isDirectory());
            System.out.println(new Date(attributes.lastModifiedTime().toMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void moveFile() {
        Path from = Paths.get("./temp", "abc.txt");
        //移动./temp/abc.txt到c:/temp/test/def.txt如果目标文件已存在，则替换
        Path to = from.getParent().resolve("test/def.txt");
        try {
            //文件大小bytes
            System.out.println(Files.size(from));
            //调用文件移动方法，如果目标文件已经存在，就替换
            Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("移动文件错误" + e.getMessage());
        }


    }

}
