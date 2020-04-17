package Java.JavaLearning.wordCount;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 11:02
 */
public class WordCounter {
    public static void main(String[] args) throws IOException {
        //接收目录参数和扩展名
        Path fileTree = Paths.get("./temp");
        Searcher walk = new Searcher("*.txt");
        //查找该目录下所有的txt文件
        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(fileTree, opts, Integer.MAX_VALUE, walk);
        ArrayList<String> filePaths = walk.getFilePaths();
        //解析每个文件的单词
        HashMap<String, Word> totalMap = new HashMap<String, Word>();
        for (String str : filePaths) {
            HashMap<String, Word> partMap = new FileAnalyzer(str).getWordCount();
            if (partMap != null && partMap.size() > 0) {
                combineMap(totalMap, partMap);
            }
        }
        //排序
        ArrayList<Word> words = new ArrayList<>(totalMap.values());
        Collections.sort(words);
        //输出
        System.out.println("最后结果");
        for (Word w : words) {
            System.out.println(w.getText()+","+w.getTimes());
        }
    }

    private static void combineMap(HashMap<String, Word> totalMap, HashMap<String, Word> partMap) {
        Iterator<Map.Entry<String, Word>> iter = partMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Word> entry = iter.next();
            //获取key
            String partKey = entry.getKey();
            //获取value
            Word partWord = entry.getValue();
            if (totalMap.containsKey(partKey)) {
                Word totalWord = totalMap.get(partKey);
                totalWord.setTimes(totalWord.getTimes() + partWord.getTimes());
            }else {
                totalMap.put(partKey, partWord);
            }
        }
    }
}
