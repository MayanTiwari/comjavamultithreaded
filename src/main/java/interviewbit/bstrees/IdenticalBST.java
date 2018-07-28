package interviewbit.bstrees;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mayan on 28/7/18.
 */
public class IdenticalBST {

    public static void main(String[] args){

    }
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A == null && B == null) return 1;
        if(A == null && B !=null ) return 0;
        if(A !=null && B == null) return 0;

        if(A.val == B.val && isSameTree(A.left,B.left)== 1 &&
                isSameTree(A.right,B.right)==1){
            return 1;
        }else{
            return 0;
        }
    }
    //TODO
    public int isSameTreeIterative(TreeNode A, TreeNode B) {
        if(A == null && B == null) return 1;
        if(A == null && B !=null ) return 0;
        if(A !=null && B == null) return 0;
        Queue<TreeNode> queueleft = new PriorityQueue<>();
        Queue<TreeNode> queueRight = new PriorityQueue<>();

       return 0;

    }
    public int isSymmetric(TreeNode A) {
        if(A == null) return 0;
        if(A.left == null && A.right == null) return 1;
        if(A.left == null && A.right !=null ) return 0;
        //if(A !=null && B == null) return 0;
        if(A.left.val == A.right.val && isSameTree(A.left,A.right)== 1){
            return 1;
        }else{
            return 0;
        }
    }
    private int isSame(TreeNode A, TreeNode B) {
        if(A == null && B == null) return 1;
        if(A == null && B !=null ) return 0;
        if(A !=null && B == null) return 0;

        if(A.val == B.val && isSameTree(A.right,B.left)== 1){
            return 1;
        }else{
            return 0;
        }
    }

}
