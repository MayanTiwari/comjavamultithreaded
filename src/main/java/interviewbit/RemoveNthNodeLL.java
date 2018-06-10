package interviewbit;

import static java.lang.System.out;

/**
 * Created by mayan on 10/6/18.
 */
public class RemoveNthNodeLL {
    public static void main(String[] args){
        RemoveNthNodeLL removeNthNodeLL = new RemoveNthNodeLL();
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(20);
        removeNthNodeLL.removeNthFromEnd(head1,0);

    }
    public ListNode removeNthFromEnd(ListNode A, int B) {

        if(A.next == null){
            out.println(A.val);
            return A;
        }

        removeNthFromEnd(A.next,0);
        out.println(A.val);
        return A;
    }

}
