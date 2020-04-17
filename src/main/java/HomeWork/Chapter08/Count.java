package HomeWork.Chapter08;

/**
 * @Description: 给定一个数,获取这个数所有可能的累加形式,变态跳青蛙组合版
 * @author: Anhlaidh
 * @date: 2020-04-17 15:47
 */
public class Count {
    public static void main(String[] args) {
        System.out.println(count(6));

    }

    /**
     * 计数
     * @param num 输入的参数
     * @return 所有可能的数量
     */
    public static int count(int num) {
        int result = 0;
        if (num==1) return 1;
        for (int i = num-1; i >0;i--) {
            result += count(num-i);

        }
        return result;

    }
}
