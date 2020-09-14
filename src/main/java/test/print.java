package test;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-07 13:23
 *
 *
 *
 */
public class print {
    void m1() {
        int max = 25;
        boolean[][] arr = new boolean[max][max];
        int mid = max / 2;
        int left = mid;
        int right = mid;
        arr[0][mid] = true;
        for (int i = 0; i < max/2; i++) {
            arr[i][left--] = true;
            arr[i][right++] = true;
        }
        arr[mid][0] = true;
        arr[mid][max - 1] = true;
        for (int i = 1; i < max/2; i++) {
            arr[i+max/2][left++] = true;
            arr[i+max/2][right--] = true;
        }
        arr[max - 1][mid] = true;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]) System.out.print("*");
                else System.out.print("\t");

            }
            System.out.println();
        }
    }
    static void m2() {
        /**
         *

         */
        System.out.println("   **\n" +
                "  ****\n" +
                "   **\n" +
                "   **\n" +
                "   **\n" +
                " ( )( )");
    }
    public static void main(String[] args) {
        m2();


    }
}
