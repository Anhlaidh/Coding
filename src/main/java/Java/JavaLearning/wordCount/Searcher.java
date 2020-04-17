package Java.JavaLearning.wordCount;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 11:09
 */
public class Searcher implements FileVisitor {
    private final PathMatcher matcher;
    private ArrayList<String> filePaths = new ArrayList<>();

    public Searcher(String ext) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + ext);
    }

    public void judgeFile(Path file) throws IOException {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            filePaths.add(file.toRealPath().toString());
        }
    }

    @Override

    public FileVisitResult preVisitDirectory(Object o, BasicFileAttributes basicFileAttributes) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object o, BasicFileAttributes basicFileAttributes) throws IOException {
        judgeFile((Path)o);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object o, IOException e) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object o, IOException e) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public ArrayList<String> getFilePaths() {
        return filePaths;
    }
}
