package SwordFingerOffer;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-18 15:51
 */
public class minNumberInRotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(new minNumberInRotateArray().minNumberInRotateArray(arr));
    }

    private int minNumberInRotateArray(int[] array) {

        return process(array, 0, array.length-1);
    }

    private int process(int[] arr, int L, int R) {
        if (L==R) {
            return arr[L];
        }
        int mid = L + ((R-L) >> 1);
        int leftMin = process(arr, L, mid);
        int rightMin = process(arr, mid + 1, R);
        return Math.min(leftMin, rightMin);
    }

//    int minNumberInRotateArray(int[] array) {
//        int left = 0;
//        int right = array.length - 1;
//        while (true) {
//            int mid = (left + right) / 2;
//
//             if (array[mid] > array[left]) {
//                left = mid;
//            }
//            if (array[mid] < array[right]) {
//                right = mid;
//            }
//            if (array[right-1]>array[right]) return array[right];
//
//        }
//
//    }

}
