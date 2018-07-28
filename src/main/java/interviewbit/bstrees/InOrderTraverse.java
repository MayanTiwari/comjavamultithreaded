package interviewbit.bstrees;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.System.out;

/**
 * Created by mayan on 24/7/18.
 */
public class InOrderTraverse {
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
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InOrderTraverse inOrderTraverse = new InOrderTraverse();
        out.println(inOrderTraverse.postorderTraversalOneStack(root));
        //out.println(inOrderTraverse.postorderTraversalOneStack(root));
        //out.println(inOrderTraverse.morrisTraversalInOrder(root));
       // out.println(inOrderTraverse.morrisTraversalPreOrder(root));
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = A;
        while (curr != null || stack.size() > 0) {
            //reach left most node of tree
            if (curr != null) {
                result.add(curr.val);
            }
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //pop the top item
            curr = stack.pop();
            result.add(curr.val);
            //We have visited left tree now visit right.
            curr = curr.right;
        }
        return result;
    }
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.push(A);

        while(!one.isEmpty()){
            TreeNode node = one.pop();
            if(node.right !=null){
                one.push(node.right);
            }
            if(node.left !=null){
                one.push(node.left);
            }
            two.push(node);
        }

        while(!two.isEmpty()){
            result.add(two.pop().val);
        }
        return result;
    }
    public ArrayList<Integer> postorderTraversalOneStack(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode curr= A;
        while(!stack.isEmpty() || curr!=null){
           if(curr != null){
               stack.push(curr);
               curr = curr.left;
           }else{
               TreeNode temp = stack.peek().right;
               if(temp == null){
                   temp = stack.pop();
                   result.add(temp.val);
                   while (!stack.isEmpty() && temp == stack.peek().right){
                       temp = stack.pop();
                       result.add(temp.val);
                   }
               }else{
                   curr = temp;

               }
           }
        }
        return result;
    }
    public ArrayList<Integer> morrisTraversalInOrder(TreeNode A){
        TreeNode curr = A;
        ArrayList<Integer> result = new ArrayList<>();
        while(curr !=null){
            if(curr.left == null){
                result.add(curr.val);
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
                    result.add(curr.val);
                    curr = curr.right   ;
                }
            }
        }
        return result;
    }
    public ArrayList<Integer> morrisTraversalPreOrder(TreeNode A){
        TreeNode curr = A;
        ArrayList<Integer> result = new ArrayList<>();
        while(curr !=null){
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode predecessor = curr.left;
                while (predecessor.right !=null && predecessor.right != curr)
                    predecessor = predecessor.right;

                if(predecessor.right == null){
                    //Add link to go back in the tree.
                    predecessor.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                }else{
                    //Remove the link.
                    predecessor.right = null;
                    curr = curr.right   ;

                }
            }
        }
        return result;
    }
}
