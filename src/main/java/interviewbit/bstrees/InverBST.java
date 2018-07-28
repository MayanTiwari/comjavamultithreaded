package interviewbit.bstrees;

import static java.lang.System.out;

/**
 * Created by mayan on 28/7/18.
 */
public class InverBST {
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
        InverBST inverBST = new InverBST();
        inverBST.invertTree(root);
    }
    public TreeNode invertTree(TreeNode A) {

        if(A == null){
            return null;
        }
        if(A.left !=null && A.right !=null){
            TreeNode temp = A.left;
            A.left = A.right;
            A.right = temp;
        }
        if(A.left!=null && A.right == null){
            A.right = A.left;
            A.left = null;
        }
        if(A.left == null && A.right!=null){
            A.left = A.right ;
            A.right = null;
        }
        invertTree(A.left);
        invertTree(A.right);

        return A;
    }

}
