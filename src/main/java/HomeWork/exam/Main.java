package HomeWork.exam;


/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-24 14:40
 */
public class Main {
    public static void main(String[] args) {
        SortImpl sort = new SortImpl();
        int[] arr = {-5,
                29, 7, 10, 5, 16};
        sort.QuickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            }
        }
        System.out.println();



    }
}
