package interviewbit;
import static java.lang.System.out;

/**
 * Created by mayan on 5/8/18.
 */
public class LLRemoveOdd {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        //1345431
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(1);
        ListNode.printLL(head);
        LLRemoveOdd llRemoveOdd = new LLRemoveOdd();
        ListNode res =  deleteOdd(head);
        ListNode.printLL(res);

    }
    public static ListNode deleteOdd(ListNode head){
        if(head == null) return null;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            //if odd is at head.
            //if odd is at tail.
            //if odd is at mid.
            if (curr.val % 2 != 0) {
                //head
                if (curr == head) {
                    head = head.next;
                    prev = head;
                    curr = curr.next;
                }else if (curr.next == null) {
                    prev.next = null;
                    curr = curr.next;
                    //curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
