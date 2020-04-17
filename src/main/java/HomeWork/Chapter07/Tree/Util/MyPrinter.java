package HomeWork.Chapter07.Tree.Util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/4 0004 20:04
 */
public class MyPrinter {
    private class Node<E>{
        Node left;
        Node right;
        Node root;
        E val;
        int height;


    }

    public interface Printable{
        Node getRoot();

        Node getLeft();

        Node getRight();

    }

    public int height() {
        int height = 0;//初始height=0
        return 0;

    }

    public static void treePrinter(Node root) {
        if (root==null) System.out.println("null" );
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue != null) {
            Node node = queue.poll();
            print(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void print(Node node) {//主输出方法
        StringBuffer str = new StringBuffer();
        int countBlank = 2 + 3 * node.height;//空格数量
        while (countBlank-- > 0) {
            str.append(" ");
        }
        str.append(node);
        while (countBlank-- > 0) {
            str.append(" ");
        }
        str.append("\n");
        while (countBlank-- > 0) {
            str.append(" ");
        }
        str.append("|");
        while (countBlank-- > 0) {
            str.append(" ");
        }
        str.append("\t");
        System.out.println(str.toString());



    }
}
