package interviewbit.bstrees;

import static java.lang.System.out;

/**
 * Created by mayan on 28/7/18.
 */
public class BSTBalanced {
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
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BSTBalanced bstBalanced = new BSTBalanced();
        out.println(bstBalanced.isBalanced(root));
    }
    public int isBalanced(TreeNode A ) {
        int lh=0;
        int rh=0;

        if(A == null){
            return 1;
        }

        lh = height(A.left);
        rh= height(A.right);

        if((Math.abs(lh-rh) <=1) && isBalanced(A.left) ==1
                && isBalanced(A.right) == 1){
            return 1;
        }
        return 0;

    }
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }else{
            return 1+ height(node.left) + height(node.right);
        }
    }
}
