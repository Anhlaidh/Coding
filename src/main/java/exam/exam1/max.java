package exam.exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-09 16:22
 */
public class max {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(reader.nextInt());
        }
        List<List<Integer>> lists = getList(list);
        int result = 0;
        for (int i = 0;i<lists.size(); i++) {
            List<Integer> integerList = lists.get(i);
            int current = oper(integerList);
            result = Math.max(result, current);
        }
        System.out.println(result);

    }

    private static int oper(List<Integer> integerList) {
        int result = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < integerList.size(); i++) {
            Integer current = integerList.get(i);
            count += current;
            min = Math.min(min, current);
        }
        result = min * count;
        return result;
    }

    public static List<List<Integer>> getList(List<Integer> ints){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (ints==null||ints.size()==0){
            return lists;
        }
        backtrack(ints,list,lists,0);


        return lists;
    }
    public static void backtrack(List<Integer> items, List<Integer> currentList, List<List<Integer>> lists,int current){
        if (currentList.size()==items.size()){
            return;
        }
        else {
            for (;current<items.size();current++){
                if (currentList.contains(items.get(current))) continue;
                currentList.add(items.get(current));
                backtrack(items,currentList,lists,current);
//                System.out.println(currentList);
                lists.add(new ArrayList<>(currentList));
                currentList.remove(currentList.size()-1);
            }
        }
    }

}
