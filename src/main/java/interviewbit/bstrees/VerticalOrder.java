package interviewbit.bstrees;

import java.util.*;

import static java.lang.System.out;

/**
 * Created by mayan on 23/7/18.
 */
public class VerticalOrder {
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
           val = x;
           left=null;
           right=null;
          }
      }

    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        VerticalOrder verticalOrder = new VerticalOrder();
        out.println(verticalOrder.verticalOrderTraversal(root));

    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        LinkedHashMap<Integer,ArrayList<Integer>> map = new LinkedHashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        inOrder(map,A,0);
        if(map.size() > 0){
            for(ArrayList<Integer> list: map.values()){
                result.add(list);
            }
        }
        return result;
    }
    private void inOrder(Map<Integer,ArrayList<Integer>> map, TreeNode node, int key){
        //Base case just return
        if(node == null){
            return;
        }
        inOrder(map,node.left,key-1);
        ArrayList arrayList = map.get(key);
        if(null != arrayList){
            arrayList.add(node.val);
        }else{
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(node.val);
            map.put(key,newList);
        }
        inOrder(map,node.right,key+1);
    }
}
