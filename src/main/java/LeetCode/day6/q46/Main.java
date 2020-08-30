package LeetCode.day6.q46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/8 0008 16:17
 */
public class Main {

   static void backtrack(List<List<Integer>> lists,List<Integer> currentList,int[] num){
        if (currentList.size()==num.length){
            lists.add(new ArrayList<>(currentList));
            return;

        }else {
            for (int i=0;i<num.length;i++){
                if (currentList.contains(num[i])) {
                    continue;
                }
                currentList.add(num[i]);

                backtrack(lists, currentList, num);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> lists =  new ArrayList<>();
        backtrack(lists,currentList,nums);
        return lists;
    }
    public static void main(String[] args) {


    }
}
