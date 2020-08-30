package Interview.Left.Heap;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-23 15:23
 */
public class HeapSort extends Heap {
    static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }


    public HeapSort(int size) {
        super(size);
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 3, 6, 2, 5, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
