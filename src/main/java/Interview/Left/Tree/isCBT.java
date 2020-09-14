package Interview.Left.Tree;

import HomeWork.Chapter07.Tree.BinaryTree;
import HomeWork.Chapter07.Tree.Util.TreePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-14 19:59
 */
public class isCBT {

    static boolean isCBT_1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;
        while (queue.size() > 0) {
            Node node = queue.poll();
            Node left = node.left;
            Node right = node.right;
            if (leaf &&(left!=null||right!=null)|| (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }

    static class nodeInfo {
        //是否为满二叉树
        boolean isFull;
        // 是否为完全二叉树
        boolean isComplete;
        int height;

        public nodeInfo(boolean isFull, boolean isComplete, int height) {
            this.isFull = isFull;
            this.isComplete = isComplete;
            this.height = height;
        }
    }

    static boolean isCBT_2(Node node) {
        return process(node).isComplete;
    }

    static nodeInfo process(Node node) {
        if (node==null) return new nodeInfo(true, true, 0);
        nodeInfo leftInfo = process(node.left);
        nodeInfo rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        boolean isComplete = false;
        if (isFull) {
            isComplete = true;
        } else {
            if (leftInfo.isComplete && rightInfo.isComplete) {
                if (rightInfo.isFull && leftInfo.height == rightInfo.height+1) {
                    isComplete = true;
                }
                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
                    isComplete = true;
                }
                if (leftInfo.isFull && rightInfo.height == leftInfo.height) {
                    isComplete = true;
                }
            }
        }
        return new nodeInfo(isFull, isComplete, height);
    }

//    static nodeInfo process(Node node) {
//        if (node==null) return new nodeInfo(true, true, 0);
//        nodeInfo leftInfo = process(node.left);
//        nodeInfo rightInfo = process(node.right);
//
//        if (leftInfo.isFull&&rightInfo.isFull&&(leftInfo.height-rightInfo.height==1||leftInfo.height==rightInfo.height))
//            return new nodeInfo(true, true, leftInfo.height+1);
//        if (leftInfo.isComplete&&rightInfo.isFull&&leftInfo.height==rightInfo.height)
//            return new nodeInfo(true, false, leftInfo.height+1);
//        if (leftInfo.isFull&&rightInfo.isComplete&&leftInfo.height==rightInfo.height)
//            return new nodeInfo(false, true, leftInfo.height+1);
//        return new nodeInfo(false, false, Math.max(rightInfo.height, leftInfo.height)+1);
//    }

    public static void main(String[] args) {
        Node node = Node.RandomTree(10, 10);
        TreePrinter.print(node);
        System.out.println(isCBT_1(node));
        System.out.println(isCBT_2(node));
    }
}
