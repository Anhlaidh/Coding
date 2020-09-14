package Interview.Left.Tree;

import HomeWork.Chapter07.Tree.BinaryTree;
import HomeWork.Chapter07.Tree.Util.TreePrinter;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-14 19:59
 */
public class Node implements TreePrinter.PrintableNode {
    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }

    public static Node RandomTree(int MaxSize, int bound) {
        Random random = new Random();
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Integer[] orderTraversal = random.ints(MaxSize, -1, bound).boxed().toArray(Integer[]::new);
        Node root = createTree(orderTraversal, 0);
        return root;
    }

    private static Node createTree(Integer[] orderTraversal, int i) {
        if (orderTraversal[i]==-1) return null;
        Node cur = new Node(orderTraversal[i]);
        Node left = null;
        Node right = null;
        if (i * 2 + 1 < orderTraversal.length) {
            left = createTree(orderTraversal, 2 * i + 1);
        }
        if (i * 2 + 2 < orderTraversal.length) {
            right = createTree(orderTraversal, 2 * i + 2);
        }
        cur.left = left;
        cur.right = right;
        return cur;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return val + "";
    }
}
