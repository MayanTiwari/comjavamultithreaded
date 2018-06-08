package interviewbit;

import java.util.List;

import static java.lang.System.loadLibrary;
import static java.lang.System.out;

/**
 * Created by mayan on 3/6/18.
 */
public class LL1 {
    static ListNode headfirst ;
    static ListNode headMid;
    public static void main(String[] args){
        LL1 ll1 = new LL1();
        //1345431
        headfirst = new ListNode(1);
        headfirst.next = new ListNode(2);
        headfirst.next.next = new ListNode(1);
        //headfirst.next.next.next = new ListNode(5);
       // headfirst.next.next.next.next = new ListNode(4);
       // headfirst.next.next.next.next.next = new ListNode(3);
       // headfirst.next.next.next.next.next.next = new ListNode(1);
        out.println(ll1.lPalin(headfirst));
        //ll1.reverse(headfirst,null);
        //move pointer to mid

    }
    public int lPalin(ListNode A) {
        int result = 1 ;
        ListNode slow = headfirst;
        ListNode fast = headfirst;
        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        //reverse half of the linklist
        reverse(slow,null);

        //Compare first half and second half
        while(headMid !=null){
            if(headMid.val != headfirst.val){
                result  = 0;
                break;
            }
            headMid = headMid.next;
            headfirst = headfirst.next;
        }

        return result;
    }
    public int getLength(ListNode a){
        int count = 0 ;
        ListNode la = a;
        while(la !=null){
            count++;
            la= la.next;
        }
        return count;
    }
    //Reverse linklist in O(n)
    public ListNode reverse(ListNode curr,ListNode prev){
     /* If last node mark it head*/
        if (curr.next == null) {
            headMid = curr;
            /* Update next to prev node */
            curr.next = prev;
            return headMid;
        }
        /* Save curr->next node for recursive call */
        ListNode next1 = curr.next;
        /* and update next ..*/
        curr.next = prev;
        reverse(next1, curr);
        return headMid;
    }


}
