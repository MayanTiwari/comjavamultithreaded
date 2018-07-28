package interviewbit.bstrees;

/**
 * Created by mayan on 28/7/18.
 */
public class FlattenBST {
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

    }
    public TreeNode flatten(TreeNode a) {
        if(a == null || (a.left == null && a.right == null) ){
            return null;
        }
        if(a.left !=null){
            flatten(a.left);
            TreeNode tempRight = a.right;
            a.right = a.left;
            a.left =null;

            TreeNode temp = a.right;
            while(a.right !=null){
                temp = temp.right;
            }
            temp.right = tempRight;
        }
        flatten(a.right);

        return a;
    }
}
