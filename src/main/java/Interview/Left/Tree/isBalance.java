package Interview.Left.Tree;

import HomeWork.Chapter07.Tree.BinaryTree;
import HomeWork.Chapter07.Tree.Util.TreePrinter;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-10 11:54
 */
public class isBalance {
    class Info{
        public boolean isBalance;
        public int height;

        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public boolean isBalance(BinaryTree<Integer> tree) {
        BinaryTree.Node<Integer> root = tree.getRoot();
        return process(root).isBalance;
    }

    public Info process(BinaryTree.Node<Integer> node) {
        if (node==null ) return new Info(true, 0);
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        if (Math.abs(leftInfo.height - rightInfo.height) > 1 || !leftInfo.isBalance || !rightInfo.isBalance) {
            return new Info(false, height);
        }
        return new Info(true, height);
    }

    public static void main(String[] args) {
        isBalance isBalance = new isBalance();
        BinaryTree<Integer> tree = BinaryTree.getDefault(20, 20);
        TreePrinter.print(tree.getRoot());
        System.out.println(isBalance.isBalance(tree));
    }

}
