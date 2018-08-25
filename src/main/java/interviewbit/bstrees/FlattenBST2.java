package interviewbit.bstrees;

/**
 * Created by mayan on 5/8/18.
 */
public class FlattenBST2 {
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
    public TreeNode flatten(TreeNode node){
        //Iterative way
        TreeNode curr = node;
        while(curr !=null){

            if(curr.left !=null){
                TreeNode temp = curr.left;
                temp = curr.left;
                while(temp.left.left !=null){

                }
            }
           // while ()
        }
        return null;
    }
}
