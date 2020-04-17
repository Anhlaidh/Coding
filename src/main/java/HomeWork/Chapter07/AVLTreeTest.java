package HomeWork.Chapter07;

import HomeWork.Chapter07.Tree.AVLTree;
import HomeWork.Chapter07.Tree.BST;
import HomeWork.Chapter07.Tree.Util.TreePrinter;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 1:02
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = random.ints(100, 0, 10).toArray();
        AVLTree avl = new AVLTree();
        BST bst = new BST();
        for (int i : ints) {
            avl.add(i);
            bst.add(i);
        }
        TreePrinter.print(avl.getRoot());
        System.out.println();
        TreePrinter.print(bst.getRoot());
    }
}
