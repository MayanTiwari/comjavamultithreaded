package interviewbit.bstrees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static java.lang.System.out;

/**
 * Created by mayan on 28/7/18.
 */
public class TwoSumBST {
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
    class ForwardIterator implements Iterator<TreeNode>{
        Deque<TreeNode> stack = new ArrayDeque<>();

        public ForwardIterator(TreeNode root) {
            this.pushAll(root);
        }
        private void pushAll(TreeNode node){
            TreeNode curr = node;
            while(curr !=null){
                stack.push(curr);
                curr= curr.right;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public TreeNode next() {
            TreeNode node = stack.pop();
            pushAll(node.left);
            return node;
        }
    }
    class ReverseIterator implements Iterator<TreeNode>{
        Deque<TreeNode> stack = new ArrayDeque<>();

        public ReverseIterator(TreeNode root) {
            this.pushAll(root);
        }
        private void pushAll(TreeNode node){
            TreeNode curr = node;
            while(curr !=null){
                stack.push(curr);
                curr= curr.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public TreeNode next() {
            TreeNode node = stack.pop();
            pushAll(node.right);
            return node;
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
        TwoSumBST twoSumBST = new TwoSumBST();
        out.println(twoSumBST.t2Sum(root,6));
    }

    public int t2Sum(TreeNode A, int B) {
        ForwardIterator forwardIterator = new ForwardIterator(A);
        ReverseIterator reverseIterator = new ReverseIterator(A);
        int l = reverseIterator.next().val;
        int r = forwardIterator.next().val;
        while(forwardIterator.hasNext() && reverseIterator.hasNext()){
            int sum = l + r;
            if(sum == B){
                return 1;
            }else if(sum > B){
                r = forwardIterator.next().val;
            }else if(sum < B){
                l = reverseIterator.next().val;
            }
        }
        return 0;
    }
}
