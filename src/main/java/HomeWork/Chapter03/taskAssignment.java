package HomeWork.Chapter03;

import HomeWork.TimeTool.TimeTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/8 0008 14:11
 */
public class taskAssignment {
    Integer[][] init(int size,int Max_cost){
        Integer[][] tasks = new Integer[size][size];
        for (int i=0;i<tasks.length;i++){
            for (int j=0;j<tasks[i].length;j++){
                tasks[i][j] = (int)(Math.random()*Max_cost)+1;
            }
        }
        return tasks;

    }

    void backtrack(List<List<Integer>> lists,List<Integer> currentList,int[] num){
        if (currentList.size()==num.length){
            lists.add(new ArrayList<>(currentList));
            return;

        }else {
            for (int i=0;i<num.length;i++){
                if (currentList.contains(num[i])) continue;
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
    List<List<Integer>> getPlans(Integer[][] tasks){
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> plans =  new ArrayList<>();
        int[] nums = new  int[tasks.length];
        for (int i=0;i<nums.length;i++){
            nums[i] = i;
        }
        backtrack(plans,currentList,nums);
        return plans;
    }
    public Integer[] solution(List<List<Integer>> plans,Integer[][] tasks){
        int Min_cost=Integer.MAX_VALUE;
        Integer[] res=null;
        for (int i=0;i<plans.size();i++){
            int cost =0;
            for (int p=0;p<tasks.length;p++){
               cost+= tasks[p][plans.get(i).get(p)];
            }
            if (cost<Min_cost){
                Min_cost=cost;
                res=plans.get(i).toArray(Integer[]::new);
            }

        }
        System.out.println("最小花费："+Min_cost);
        return res;
    }
    public static void main(String[] args) {
        taskAssignment taskAssignment = new taskAssignment();
        Integer[][] tasks = taskAssignment.init(5,10);
        List<List<Integer>> plans = taskAssignment.getPlans(tasks);
//        System.out.println(plans);
        TimeTool.check("Task_Assignment", new TimeTool.Task() {
            @Override
            public void execute() {
                List<List<Integer>> plans = taskAssignment.getPlans(tasks);
                Integer[] res = taskAssignment.solution(plans, tasks);
                System.out.println("任务坐标:");
                for (int i=0;i<tasks.length;i++){
                    for (int j=0;j<tasks[i].length;j++){
                        if (j==res[i]) {
                            System.out.print("["+tasks[i][j]+"]"+" ");
                            continue;
                        }
                        System.out.print(tasks[i][j]+" ");
                    }
                    System.out.println();
                }
            }
        });

    }
}
