package HomeWork.Chapter07.Tree;

import HomeWork.Chapter07.Tree.Util.TreePrinter;

import java.util.Comparator;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 23:34
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
//        Integer[] arr = new Integer[]{4, 5, 3, 6, 2, 5, 1};
//        Integer[] arr = new Integer[]{7, 4, 9, 2, 5};
        Integer[] arr = new Integer[]{
                71, 94, 89, 36, 95, 56, 80, 48, 62, 13, 50, 45, 5, 99, 64, 12, 92, 76
        };
        BST<Integer> bst = new BST<>();
        AVLTree avl = new AVLTree();
        BST<Integer> bst1 = new BST<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer integer : arr) {
//            bst.add(integer);
            avl.add(integer);
        }
        TreePrinter.print(avl.getRoot());
        TreePrinter.print(bst.getRoot());
        System.out.println(avl.isComplete());

    }
}
