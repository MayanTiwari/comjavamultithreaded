package interviewbit.bstrees;

import java.util.ArrayList;

/**
 * Created by mayan on 28/7/18.
 */
public class BSTFromPrePost {
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
        A.add(2);
        A.add(1);
        A.add(3);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(3);
        B.add(1);
        BSTFromPrePost bstFromPrePost = new BSTFromPrePost();
        TreeNode node = bstFromPrePost.buildTree(A,B);
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildTree(A,B,0,A.size()-1,B.size()-1);
    }
    private TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B,int start,int end,int index){
        if(start > end){
            return null;
        }
        TreeNode node = new TreeNode(B.get(index));
        index--;

        if(start == end){
            return node;
        }
        int iIndex = search(A,start,end,node.val);

        node.right = buildTree(A,B,iIndex+1,end,index);
        node.left = buildTree(A,B,start,iIndex-1,index);

        return node;

    }
    int search(ArrayList<Integer> list, int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++)
        {
            if (list.get(i) == value)
                break;
        }
        return i;
    }


}
