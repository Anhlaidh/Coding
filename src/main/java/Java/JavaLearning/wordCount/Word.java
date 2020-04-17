package Java.JavaLearning.wordCount;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 12:19
 */
public class Word implements Comparable<Word>{
    private String text;//单词文本
    private int times;//单词次数

    public Word() {
    }

    public Word(String text, int times) {
        this.text = text;
        this.times = times;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public int compareTo(Word word) {
        return (-1) * (this.getTimes() - word.getTimes());
    }
}
