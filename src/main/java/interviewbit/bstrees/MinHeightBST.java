package interviewbit.bstrees;

import java.util.Deque;

import static java.lang.System.out;

/**
 * Created by mayan on 29/7/18.
 */
public class MinHeightBST {
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
        MinHeightBST minHeightBST = new MinHeightBST();
        out.println(minHeightBST.minDepth(root));

    }

    public int minDepth(TreeNode A) {
        int lDepth = 0;
        int rDepth = 0;
        if (A == null) {
            return 0;
        }
        if (A.left == null && A.right == null) {
            return 1;
        }
        if (A.left == null) {
            return minDepth(A.right) + 1;
        }
        if (A.right == null) {
            return minDepth(A.left) + 1;
        }

        return Math.min(minDepth(A.right), minDepth(A.left)) + 1;
    }
}

