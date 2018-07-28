package interviewbit.bstrees;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.System.out;

/**
 * Created by mayan on 28/7/18.
 */
public class KthSmallestElement {
    class Count {
        int count = 0;
    }
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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right= new TreeNode(3);
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        int res = kthSmallestElement.kthsmallest(root,3);
        out.println(res);

    }
    public int kthsmallest(TreeNode A, int B) {
        return morrisTraversalInOrder(A,B);
    }
    public int morrisTraversalInOrder(TreeNode A,int k){
        TreeNode curr = A;
        int count = 1;
        while(curr !=null){
            if(curr.left == null){
                if(count == k){
                    return curr.val;
                }
                curr = curr.right;
            }else{
                TreeNode predecessor = curr.left;
                while (predecessor.right !=null && predecessor.right != curr)
                    predecessor = predecessor.right;

                if(predecessor.right == null){
                    //Add link to go back in the tree.
                    predecessor.right = curr;
                    curr = curr.left;
                }else{
                    //Remove the link.
                    predecessor.right = null;
                    count++;
                    if(count == k){
                        return curr.val;
                    }
                    curr = curr.right   ;
                }
            }
        }
        return -1;
    }
    private int inOrder(TreeNode node,Count c,int k){
        if(node == null){
            return 0;
        }
        inOrder(node.left,c,k);
        c.count++;
        if(c.count == k){
            return node.val;
        }
        inOrder(node.right,c,k);
        return 0;
    }
}
