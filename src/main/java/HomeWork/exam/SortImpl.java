package HomeWork.exam;

import HomeWork.sort.ISort;

import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 15:36
 */
public class SortImpl implements ISort {

    /**
     * 快速排序  O(nLog2n)
     * 一分为三,第一个数字为mid,分成比mid小,比mid大两个数组
     * 可知左边的一定比mid小,右边的一定比mid大
     * 递归拆分,合并即可获得有序数组
     * @param array 数组
     * @return 有序数组
     */
    @Override
    public int[] QuickSort(int[] array) {
        if (array.length<=1) {
            return array;
        }
        int mid = array[0];
        int left=1;
        int current=0;
        int right=array.length-1;
       while (left!=right){
           while (left!=right){
               if (array[right]>=mid) {
                   right--;
               } else {
                   array[current] = array[right];
                   current = right;
                   right--;
                   break;
               }
           }
          while (left!=right){

              if (array[left]<mid) {
                  left++;
              } else {
                  array[current] = array[left];
                  current = left;
                  left++;
                  break;
              }
          }

       }
        int[] l = Arrays.copyOfRange(array, 0, current);
        int[] r = Arrays.copyOfRange(array, current + 1, array.length);
        int[] l_sort = QuickSort(l);
        int[] r_sort = QuickSort(r);

        array[current] = mid;

        System.arraycopy(l_sort,0,array,0,l_sort.length);
        System.arraycopy(r_sort,0,array,current+1,r_sort.length);

        return array;

    }

    /**
     * 归并排序O(nLog2n)
     * 将数组一分为二一分为二,递归拆分成只有一个数字
     * 根据大小,来组合成有序数组
     * @param array 无序数组
     */

    @Override
    public void MergeSort(int[] array) {
        int mid = array.length/2;
        int[] left = null;
        int[] right=null;
        if (array.length>1){
            //TODO 分成两个数组
            left = Arrays.copyOfRange(array, 0, mid);
             right = Arrays.copyOfRange(array, mid , array.length);
            MergeSort(left);
            MergeSort(right);
        }
        Merge(array,left,right);

    }

    private void Merge(int[] array, int[] left, int[] right) {
        if (left==null||right==null) {
            array=array;
        } else {
           int l=0;
           int r=0;
           int i=0;
           while (i<array.length){
               if (left[l]<right[r]){
                   array[i] = left[l];
                   l++;
                   i++;
                   if (l>=left.length){
                       while (r<right.length){
                           array[i] = right[r];
                           r++;
                           i++;
                       }
                   }
               }
               else{
                   array[i] = right[r];
                   r++;
                   i++;
                   if (r>=right.length){
                       while (l<left.length){
                           array[i] = left[l];
                           i++;
                           l++;
                       }

                   }

               }
           }
        }
    }

    /**
     * 冒泡排序O(n2)
     * 依次比较,当前数字大于比较数字则交换,否则不变,将大数冒到最右
     * 循环冒泡,得到有序数组
     * @param array 无序数组
     */
    @Override
    public void BubbleSort(int[] array) {
        for (int j = array.length; j > 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+",");
                if (i == array.length - 1) {
                    System.out.print(array[i]);
                }
            }
            System.out.println();

        }
    }

    /**
     * 选择排序O(n2)
     * 遍历数组,找到最小值,与array[i]交换,以此类推
     * @param array
     */
    @Override
    public void SelectSort(int[] array) {
        for (int i =0;i<array.length;i++){
            int min=i;
            for (int j=i ;j <array.length;j++){

                if (array[j] <array[min]){
                    min = j;
                }
            }
            if (min!=i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k]+",");
                if (k == array.length - 1) {
                    System.out.print(array[k]);
                }
            }

        }

    }

    /**
     * 直接插入排序O(n2)
     * 依次遍历剩余数组,与当前尾节点比较,决定插入位置,循环插入
     * @param array
     */
    @Override
    public void InsertionSort(int[] array) {
        int index = 0;//当前排好序的尾节点


        while (index < array.length) {
            int minIndex = index; // 遍历列表最小值坐标
            for (int i = index; i < array.length; i++) {
                minIndex = array[i] < array[minIndex] ? i : minIndex;
                //找到最小值并记录坐标

            }
            {
                int temp = array[minIndex];
                array[minIndex] = array[index];
                array[index] = temp;
            }
            //交换位置
            for (int i = index-1; i >= 0; i--) {
                if (array[i] >= array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            index++;
        }
    }

    @Override
    public int[] CountSort(int[] A, int min, int max) {
        return new int[0];
    }
}
