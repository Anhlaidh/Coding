package Java.JavaLearning.JCF.entities;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 16:17
 */
public class Tiger implements Comparable{
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Object o) {
        return size-((Tiger) o).getSize();
    }

    public Tiger(int size) {
        this.size = size;
    }
}
