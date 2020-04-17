package LeetCode.day6.q78;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/7 0007 23:09
 */
public class Main {
    public void backtrack(int[] items, List<Integer> currentList, List<List<Integer>> lists,int current){
        if (currentList.size()==items.length){

            return;
        }
        else {
            for (;current<items.length;current++){
                if (currentList.contains(items[current])) continue;
                currentList.add(items[current]);
                backtrack(items,currentList,lists,current);
//                System.out.println(currentList);
                lists.add(new ArrayList<>(currentList));

                currentList.remove(currentList.size()-1);
            }
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (nums==null||nums.length==0){
            return lists;
        }
        backtrack(nums,list,lists,0);
        lists.add(new ArrayList<>());
        return lists;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1,2,3,4};
        System.out.println(main.subsets(nums));
    }
}
