package interviewbit.bstrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayan on 29/7/18.
 */
public class RootToLeafSum {
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
        RootToLeafSum rootToLeafSum = new RootToLeafSum();
        ArrayList<ArrayList<Integer>> res = rootToLeafSum.pathSum(root,11);

    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        rootToLeafSum(A,B,list,listArrayList);
        return listArrayList;
    }
    public boolean rootToLeafSum(TreeNode root,int sum,
                                            ArrayList<Integer> currentList,
                                            ArrayList<ArrayList<Integer>> listofList){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null ){
            if(root.val == sum){
                currentList.add(root.val);
                listofList.add(currentList);
                currentList = new ArrayList<>();
                return true;
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                return false;
            }
        }
        if(rootToLeafSum(root.left,sum - root.val,currentList,listofList)){
            currentList.add(root.val);
            return true;
        }
        if(rootToLeafSum(root.right,sum - root.val,currentList,listofList)){
            currentList.add(root.val);
            return true;
        }
        return false;
    }

}
