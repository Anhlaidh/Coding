package exam.exam3;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-09 20:23
 */
public class refactorTree {
    public static void main(String[] args) {
        refactorTree refactorTree = new refactorTree();
        int[] arr = new int[]{
                1, 3, 5, 6, 7, 8
        };
        int[] a = new int[]{
                3, 5, 1, 6, 8, 7
        };

        refactorTree.reConstructBinaryTree(arr, a);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre.length==0&&in.length==0) return null;

        int root_val = pre[0];
        int root_index = 0;
        TreeNode node = new TreeNode(root_val);

        if (pre.length==1&&in.length==1)return node;
        for (int i = 0; i < in.length; i++) {
            if (in[i]==root_val) root_index = i;
        }

        int[] in_left = copy(in, 0, root_index);
        int[] in_right = copy(in, root_index+1, in.length);
        int[] pre_left = copy(pre, 1, in_left.length+1);
        int[] pre_right = copy(pre, in_left.length+1, pre.length);

        node.left = reConstructBinaryTree(pre_left, in_left);
        node.right = reConstructBinaryTree(pre_right, in_right);


        return node;

    }

    public static int[] copy(int[] range, int from, int to) {
        int[] ints = new int[to-from];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = range[i + from];
        }
        return ints;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}