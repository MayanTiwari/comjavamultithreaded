package interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.System.out;

/**
 * Created by mayan on 22/7/18.
 */
public class KSortedLinkedListMerge {

      static class ListNode {
          public int val;
         public ListNode next;
         ListNode(int x) { val = x; next = null; }
      }


    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(10);
        l1.next.next = new ListNode(20);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(13);

        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(8);
        l3.next.next = new ListNode(9);

        ArrayList<ListNode>  listNodes = new ArrayList<>();
        listNodes.add(l1);
        listNodes.add(l2);
        listNodes.add(l3);
        KSortedLinkedListMerge kSortedLinkedListMerge = new KSortedLinkedListMerge();
        ListNode res = kSortedLinkedListMerge.mergeKLists(listNodes);
        out.println(res);
    }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        Comparator<ListNode> comparator = (o1,o2) ->  o1.val - o2.val;
        PriorityQueue<ListNode> pQ = new PriorityQueue<>(a.size(),comparator);
        ListNode head =null;
        ListNode curr = null;

        //Enter first elements.
        for(ListNode n : a){
            pQ.add((n));
        }
        while(!pQ.isEmpty()){
            ListNode node = pQ.poll();
            if(node.next !=null){
                pQ.add(node.next);
            }
            if(head == null){
                head = node;
                curr = node;
            }else{
                curr.next = node;
                curr = node;
            }
        }
        return head;
    }

}
