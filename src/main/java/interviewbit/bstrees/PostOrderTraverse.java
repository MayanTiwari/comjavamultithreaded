package interviewbit.bstrees;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by mayan on 24/7/18.
 */
public class PostOrderTraverse {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
    }
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        return null;
    }
}
