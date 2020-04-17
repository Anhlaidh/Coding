package Java.JavaLearning.Format;

import java.text.MessageFormat;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 15:37
 */
public class MessageFormatTest {
    public static void main(String[] args) {
        //模板
        String message = "{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13},{14},{15},{16}";
        Object[] arr = new Object[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q"};
        String value = MessageFormat.format(message, arr);
        System.out.println(value);
        message = "oh,{0,number,#.##} is a good number";
        arr = new Object[]{3.1415};
        value = MessageFormat.format(message, arr);
        System.out.println(value);
    }
}
