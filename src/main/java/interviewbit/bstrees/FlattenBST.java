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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        FlattenBST flattenBST = new FlattenBST();
        flattenBST.flatten(root);

    }
    public TreeNode flatten(TreeNode a) {
        if(a==null)
            return null;
        TreeNode node=a;
        while(node!=null)
        {
            if(node.left!=null)
            {
                TreeNode rightmost=node.left;
                while(rightmost.right!=null)
                {
                    rightmost=rightmost.right;
                }
                rightmost.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node=node.right;
        }
        return a;

    }
  /*  public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        if (root.left != null) {
            flatten(root.left);
            TreeNode tmpRight = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode t = root.right;
            while (t.right != null) {
                t = t.right;
            }
            t.right = tmpRight;
        }
        flatten(root.right);
    }*/
  /*  public TreeNode flattenTree(TreeNode node){
        //Base case
        if(node == null || (node.left == null && node.right == null)){
            return null;
        }

        if(node.left !=null){
            flatten(node.left);
            TreeNode tempRight = node.right;
            node.right = node.left;
            TreeNode t = node.right;
            while (t.right !=null){
                t = t.right;
            }
            tempRight.right = t;
        }
        flatten(node.right);

        return node ;
    }
   /* public TreeNode flattenUsingStack(TreeNode root){
        if(root.left == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        while(!stack.isEmpty()){

        }
        return null;
    }
    public TreeNode flatten(TreeNode a) {
        if (a == null) return a;
        TreeNode rtree = a.right;
        if (a.left != null) {
            a.right = a.left;
            a.left = null;
            a = flatten(a.right);
        }
        if (rtree != null) {
            a.right = rtree;
            a = flatten(a.right);
        }
        return a;
    }
*/

}
