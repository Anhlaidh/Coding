package LeetCode.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 21:58
 */
public class q792 {
    public void MergeSort(int[] array) {
        int mid = array.length/2;
        int[] left = null;
        int[] right=null;
        if (array.length>1){
            left = Arrays.copyOfRange(array, 0, mid);
            right = Arrays.copyOfRange(array, mid , array.length);
            MergeSort(left);
            MergeSort(right);
        }
        Merge(array,left,right);

    }

    private void Merge(int[] array, int[] left, int[] right) {
        if (left==null||right==null) array=array;
        else {
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
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        MergeSort(nums);
        for (int i :nums){
            res.add(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        q792 q792 = new q792();
        System.out.println(q792.sortArray(arr));


    }
}
