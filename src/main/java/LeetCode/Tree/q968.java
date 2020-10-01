package LeetCode.Tree;

/**
 * @Description: https://leetcode-cn.com/problems/binary-tree-cameras/
 * @author: Anhlaidh
 * @date: 2020-09-22 14:12
 */
@SuppressWarnings("/ALL")
public class q968 {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
//        node0.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.right = node4;
        System.out.println(minCameraCover(node0));
    }
    public static int minCameraCover(TreeNode root) {
        NodeInfo process = process(root);
        if (root.right==null&&root.left==null) return 1;
        return Math.min(process.falseCount, process.trueCount);

    }

    static NodeInfo process(TreeNode node) {
        if (node == null) {
            return null;
        }
        NodeInfo left = process(node.left);
        NodeInfo right = process(node.right);
        int trueCount=0;
        int falseCount=0;
        if (left != null) {
            trueCount += left.falseCount ;
            falseCount += left.trueCount ;
        }
        if (right != null) {
            trueCount += right.falseCount ;
            falseCount += right.trueCount;
        }
        return new NodeInfo(++trueCount, falseCount);

    }
    static class NodeInfo{
        int trueCount;
        int falseCount;

        public NodeInfo(int trueCount, int falseCount) {
            this.trueCount = trueCount;
            this.falseCount = falseCount;
        }
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