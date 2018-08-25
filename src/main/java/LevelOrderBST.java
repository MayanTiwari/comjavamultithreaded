import interviewbit.bstrees.TreeNode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mayan on 6/8/18.
 */
public class LevelOrderBST {

    public ArrayList<TreeNode> order(TreeNode node){
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.offer(node);
        ArrayList<TreeNode> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode last = queue.poll();
            result.add(last);
            queue.offer(last.left);
            queue.offer(last.right);
        }
        return result;
    }
    public void deleteNodes(TreeNode root,TreeNode prevNode){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            //last node
            //prev nodeinfo
            if(prevNode.left == root){
                prevNode.left =null;
            }
            if(prevNode.right== root){
                prevNode.right =null;
            }
        }
        deleteNodes(root.left,root);
        deleteNodes(root.right,root);
    }
}
