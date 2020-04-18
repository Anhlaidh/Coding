package LeetCode.day13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:404. 左叶子之和  https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @author: Anhlaidh
 * @date: 2020-04-18 13:57
 */
public class q404 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(sumOfLeftLeaves(node1));

    }
    public static int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if (root==null) return 0;
        if (root.left!=null) result += sumOfLeftLeaves(root.left);
        if (root.right!=null) result += sumOfLeftLeaves(root.right);
        if(root.left!=null&&root.left.left==null&&root.left.right==null) result += root.left.val;
        return result;
    }

}
class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) { val = x; }
}