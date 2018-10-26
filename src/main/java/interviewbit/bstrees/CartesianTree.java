package interviewbit.bstrees;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mayan on 28/7/18.
 */
public class CartesianTree {
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
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        CartesianTree cartesianTree = new CartesianTree();
        TreeNode treeNode = cartesianTree.buildTree(A);

    }
    public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode root = new TreeNode(0);
        buildTree(A,0,A.size()-1,root);
        return root;
    }
    public TreeNode buildTree(ArrayList<Integer> A,int start,int end,TreeNode node) {
        if(start > end) return null;
        int i = findMaxIndex(A);
        node = new TreeNode(A.get(i));
        if(start == end) return node;
        node.left = buildTree(A,start,i-1,node);
        node.right = buildTree(A,i+1,end,node);

        return node;

    }
    public int findMaxIndex(ArrayList<Integer> A){
        return A.indexOf(Collections.max(A));
    }
}
