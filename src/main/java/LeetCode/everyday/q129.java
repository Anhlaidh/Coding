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
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);


        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        System.out.println(sumNumbers(t1));
    }
    //递归

    public static int sumNumbers(TreeNode root) {
        if (root==null) return 0;
//        ArrayList<int[]> dfs = DFS(root);
        ArrayList<String > res = Recursion(root);
        int sum = 0;
//        for (int i = 0; i < dfs.size(); i++) {
//            int[] cur = dfs.get(i);
//            StringBuilder str = new StringBuilder();
//            for (int j = 0; j < cur.length; j++) {
//                str.append(cur[j]);
//            }
//            sum += Integer.parseInt(str.toString());
//        }
        for (int i = 0; i < res.size(); i++) {
            sum += Integer.parseInt(res.get(i));
        }
        return sum;
    }

    private static ArrayList<String > Recursion(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        process(root, list,str.append(root.val));
        return list;
    }

    private static void process(TreeNode root, ArrayList<String> list,StringBuilder str) {
        if (root.left == null&&root.right==null) {
            list.add(str.toString());
            return;
        }
        if (root.left != null) {
            process(root.left, list, str.append(root.left.val));
            str.deleteCharAt(str.length()-1);
        }
        if (root.right != null) {
            process(root.right,list, str.append(root.right.val));
            str.deleteCharAt(str.length()-1);
        }

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
