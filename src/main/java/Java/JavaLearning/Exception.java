package Java.JavaLearning;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/9 0009 21:27
 */
public class Exception {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        try {
            System.out.println(a[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());;
//            e.printStackTrace();
        }
        System.out.println("end");
    }
}
