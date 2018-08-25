package interviewbit.bstrees;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 29/7/18.
 */
public class PathSum {
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
        PathSum pathSum = new PathSum();
        List<Integer> result = new ArrayList<>();
        out.println(pathSum.rootToLeafSum(root,11,result));
        out.println(result);
    }
    public int hasPathSum(TreeNode A, int B) {
        int result = 0;
        if(A == null){
            return 0;
        }else{
            int subSum = B - A.val;
            if(subSum == 0 && A.left == null && A.right == null){
                return 1;
            }
            if(A.left !=null){
             //   result = (result == 0) || (hasPathSum(A.left,subSum) == 0);
            }
        }
        //return hasPathSum(A,0,B);
        return 0;
    }
    //TODO;
    public int hasPathSum(TreeNode node,int currentSum, int B) {

        if(node == null){
            return 0;
        }
        if(currentSum == B){
            return 1;
        }
        currentSum = node.val;
        hasPathSum(node.left,currentSum,B);
        hasPathSum(node.right,currentSum,B);
        return 0;
    }
    public boolean rootToLeafSum(TreeNode root,int sum,List<Integer> result){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null ){
            if(root.val == sum){
                result.add(root.val);
                return true;
            }else{
                return false;
            }
        }
        if(rootToLeafSum(root.left,sum - root.val,result)){
            result.add(root.val);
            return true;
        }
        if(rootToLeafSum(root.right,sum - root.val,result)){
            result.add(root.val);
            return true;
        }
        return false;
    }


}
