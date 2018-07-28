package interviewbit.bstrees;

import java.util.Stack;

/**
 * Created by mayan on 28/7/18.
 */
public class BSTIterator {

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

    }

    Stack<TreeNode> stack = new Stack<>();
    public void BSTIterator(TreeNode root){
       this.pushAll(root);
    }
    public int next(){
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode node){
        TreeNode curr = node;
        while(curr !=null){
            stack.push(curr);
            curr= curr.left;
        }
    }


}
