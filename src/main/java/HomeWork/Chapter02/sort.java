package HomeWork.Chapter02;


import HomeWork.TimeTool.TimeTool;
import HomeWork.sort.SortImpl;

/**
 * @Description: sort
 * @author: Anhlaidh
 * @date: 2020/2/28 0028 14:58
 */
public class sort {

    public static void main(String[] args) {
    int[] array = new int[10];
    for (int i = 0;i<array.length;i++){
        array[i] = (int)(Math.random()*100);
    }
        SortImpl sort = new SortImpl();
    int [] SelectSort_T = array.clone();
    TimeTool.check("SelectSort", new TimeTool.Task() {
            @Override
            public void execute() {
                sort.SelectSort(SelectSort_T);
            }
        });
    for (int i =0;i<SelectSort_T.length;i++){
        System.out.print(SelectSort_T[i]+"\t");
    }
        System.out.println();
    int[] BubbleSort_T = array.clone();
    TimeTool.check("BubbleSort", new TimeTool.Task() {
        @Override
        public void execute() {
            sort.BubbleSort(BubbleSort_T);
        }
    });
        for (int i =0;i<SelectSort_T.length;i++){
            System.out.print(BubbleSort_T[i]+"\t");
        }

    }

}
