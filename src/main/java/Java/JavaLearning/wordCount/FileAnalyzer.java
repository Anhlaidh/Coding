package Java.JavaLearning.wordCount;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 12:21
 */
public class FileAnalyzer {
    private String fileStr;

    public FileAnalyzer(String fileStr) {
        this.fileStr = fileStr;
    }

    /*
     * getWordCount()获取一个文件内的单词数
     * @return
     * */
    public HashMap<String, Word> getWordCount() {
        HashMap<String, Word> result = new HashMap<String, Word>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileStr)))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (null != word && word.length() > 0) {
                        if (result.containsKey(word)) {
                            Word w = result.get(word);
                            w.setTimes(w.getTimes() + 1);
                        } else {
                            result.put(word, new Word(word, 1));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
