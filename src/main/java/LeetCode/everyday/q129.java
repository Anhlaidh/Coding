package LeetCode.everyday;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-29 16:19
 */
public class q129 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);


        t1.left = t2;
        t1.right = t3;

        sumNumbers(t1);
    }

    public static int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        ArrayList<int[]> dfs = DFS(root);
        int sum = 0;
        for (int i = 0; i < dfs.size(); i++) {
            int[] cur = dfs.get(i);
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < cur.length; j++) {
                str.append(cur[j]);
            }
            sum += Integer.parseInt(str.toString());
        }
        return sum;
    }

    private static ArrayList<int[]> DFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        stack.add(root);
        set.add(root);
        ArrayList<int[]> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int size = stack.size();
            TreeNode cur = stack.pop();
            if (cur.left != null && !set.contains(cur.left)) {
                stack.add(cur);
                stack.add(cur.left);
                set.add(cur.left);
                continue;
            }
            if (cur.right != null && !set.contains(cur.right)) {
                stack.add(cur);
                stack.add(cur.right);
                set.add(cur.right);
                continue;
            } if (cur.left==null&&cur.right==null&&size>1){

                int[] arr = new int[size];
                Object[] nodes = stack.toArray();
                for (int i = 0; i < nodes.length; i++) {
                    arr[i] = ((TreeNode)nodes[i]).val;
                }
                arr[size-1] = cur.val;
                list.add(arr);
            }

        }
        return list;
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
