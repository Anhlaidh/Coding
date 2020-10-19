package LeetCode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-14 16:10
 */
public class q297 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(serialize(root));
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                str.append(node.val+",");
            } else {
                str.append("null"+",");
                continue;
            }

            queue.add(node.left);
            queue.add(node.right);
        }
        String result = format(str);

        return result;

    }

    private static String format(StringBuilder str) {
        String[] split = str.toString().split(",");
        int length = 0;
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("null")) {
                length = i;
            }
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i <= length; i++) {
            result.append(split[i]);
            if (i < length) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
