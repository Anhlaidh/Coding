package Interview.Left.Heap;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-23 14:56
 */
public class Heap {
    int heapSize = 0;
    int Max;
    int[] arr;

    public Heap(int max) {
        Max = max;
        arr = new int[max];
    }

    void push(int i) {
        arr[heapSize] = i;
        int child = heapSize;

        int father = (child - 1) / 2;
        //循环与父节点判断大小,保证子节点小于父节点
        while (arr[child]>arr[father]) {
            swap(arr, child, father);
            child = father;
            father = (child-1)/2;
        }
        heapSize++;
    }

     static void swap(int[] arr, int child, int father) {
        int temp = arr[child];
        arr[child] = arr[father];
        arr[father] = temp;
    }

    int pop() {
        if (heapSize==0) {
            return 0;
        }
        int ret = arr[0];
        //将最后一个节点放入头节点
        arr[0] = arr[--heapSize];
        //下沉这个节点
        heapify(arr, 0, heapSize);
        return ret;
    }
    // 下沉
    static void heapify(int[] arr,int index, int heapSize) {
        int left = index * 2 + 1;
        int largest;
        //如果index节点小于孩子则下沉,直到没有左孩子
        while (left < heapSize) {
            largest = (left + 1 < heapSize) && (arr[left + 1] > arr[left]) ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            //当前的节点如果比两个孩子节点大,跳出
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void main(String[] args) {
        //4536241
        Heap heap = new Heap(10);
        int[] a = new int[]{4, 5, 3, 6, 2, 5, 1};
        for (int i = 0; i < a.length; i++) {
            heap.push(a[i]);
        }
        for (int i = 0; i < heap.arr.length; i++) {
            System.out.println(heap.pop());

        }

    }
}
