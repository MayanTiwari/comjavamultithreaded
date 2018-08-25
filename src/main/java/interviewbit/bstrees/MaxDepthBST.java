package interviewbit.bstrees;

/**
 * Created by mayan on 29/7/18.
 */
public class MaxDepthBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        MaxDepthBST maxDepthBST = new MaxDepthBST();
        int res = maxDepthBST.minDepth(root,Integer.MAX_VALUE);

    }
    public int maxDepth(TreeNode A) {
        if(A == null){
            return 0;
        }
        int ldepth = maxDepth(A.left);
        int rDepth = maxDepth(A.right);

        return ldepth < rDepth ? ldepth + 1 : rDepth + 1;
    }
    public int minDepth(TreeNode A,int min) {
        if(A == null){
            return 0;
        }
        int lDepth = minDepth(A.left,min);
        if(lDepth < min){
            min = lDepth;
        }
        int rDepth = minDepth(A.left,min);
        if(rDepth < min){
            min = rDepth;
        }
        return min;
    }
}
