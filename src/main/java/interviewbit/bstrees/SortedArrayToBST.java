package interviewbit.bstrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayan on 28/7/18.
 */
public class SortedArrayToBST {
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
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(A);
    }
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return  bst(a,0,a.size()-1);
    }
    private TreeNode bst(List<Integer> a,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = bst(a,start,mid-1);
        node.right = bst(a,mid+1,end);
        return node;

    }

}
