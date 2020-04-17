package HomeWork.Chapter04;

import HomeWork.sort.SortImpl;
import Tools.TimeTool.TimeTool;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 18:47
 */
public class sort {
    public static void main(String[] args) {

        SortImpl sort = new SortImpl();
        Random random = new Random();
//

        TimeTool.check("QuickSort", new TimeTool.Task() {
            @Override
            public void execute() {
                int[] array =random.ints(30,0,100).toArray();//
//                sort.QuickSort(array);
                for (int a:sort.QuickSort(array)) System.out.println(a);
            }
        });
        TimeTool.check("MergeSort", new TimeTool.Task() {
            @Override
            public void execute() {
                int[] array =random.ints(30,0,100).toArray();
                sort.MergeSort(array);
            }
        });
        TimeTool.check("BubbleSort", new TimeTool.Task() {
            @Override
            public void execute() {
                int[] array =random.ints(30,0,100).toArray();
                sort.BubbleSort(array);
            }
        });
        TimeTool.check("SelectSort", new TimeTool.Task() {
            @Override
            public void execute() {
                int[] array =random.ints(30,0,100).toArray();
                sort.SelectSort(array);
            }
        });
    }
}
