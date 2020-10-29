package LeetCode.everyday;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-27 12:31
 */
public class q144 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(preorderTraversal(null));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        process(root, list);
        DFS(root, list);
        return list;
    }

    private static void DFS(TreeNode root, List<Integer> list) {
        if (root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        stack.add(root);
        list.add(root.val);
        set.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null&&!set.contains(node.left)) {
                stack.add(node);
                stack.add(node.left);
                set.add(node.left);
                list.add(node.left.val);
                continue;
            }
            if (node.right != null && !set.contains(node.right)) {
                stack.add(node);
                stack.add(node.right);
                set.add(node.right);
                list.add(node.right.val);
            }
        }

    }

    private void process(TreeNode root, List<Integer> list) {
        if (root==null) return;
        list.add(root.val);
        process(root.left, list);
        process(root.right, list);


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
