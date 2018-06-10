package interviewbit;

import static java.lang.System.out;

/**
 * Created by mayan on 6/6/18.
 */
public class RemoveDeupLL {
    public static void main(String[] args){
        RemoveDeupLL removeDeupLL = new RemoveDeupLL();
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        //head.next.next.next.next.next = new ListNode(3);

        head = removeDeupLL.deleteDuplicatesDist(head);
        ListNode.printLL(head);
    }
    //use sorted list and remove duplicates
    public ListNode deleteDuplicates(ListNode A) {
        /*Another reference to head*/
        ListNode current = A;


        /* Pointer to store the next pointer of a node to be deleted*/
        ListNode next_next;
        /* do nothing if the list is empty */
        if (current == null)
            return null;

        /* Traverse list till the last node */
        while (current.next != null) {

            /*Compare current node with the next node */
            if (current.val == current.next.val) {
                next_next = current.next.next;
                current.next = null;
                current.next = next_next;
            }
            else // advance if no deletion
                current = current.next;
        }
        return A;
    }
    public ListNode deleteDuplicatesDist(ListNode A) {
        ListNode current = A;
        ListNode prev = null;
        ListNode temp = null;
        if (current == null)
            return null;
        while (current.next != null) {
            boolean containsDup = false;
            while(current.next !=null && current.val == current.next.val){
                current = current.next;
                containsDup = true;
            }
            if(containsDup){
                if(prev == null && current.next !=null){
                    temp = current.next;
                    current.next = null;
                    current= A = temp;
                }else if(current.next !=null){
                    prev.next = current.next;
                }else if(prev !=null) {
                     prev.next= null;//prev;
                }else {
                    A = null;
                }

            }else{
                prev = current;
                current = current.next;
            }
        }
        return A;
    }

}
