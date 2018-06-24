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
        head1.next.next.next = new ListNode(25);
        //
        ListNode head = removeNthNodeLL.removeNthFromEnd(head1,4 );
        ListNode.printLL(head);

    }
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode runner = A;
        ListNode curr = A;
        ListNode prev = null;
        //Move runner to nth location
        for(int i = 1; i < B && runner.next!=null  ; i++ ){
            runner = runner.next;
        }
        //Make curr and runner n distance appart.
        while(runner.next !=null){
            prev = curr;
            curr = curr.next;
            runner = runner.next;
        }
        if(prev == null){ // N is more or equal to size of list.
            //remove head
            ListNode listNode = A.next;
            A = null;
            A = listNode;
            //A = A.next;
        }else{
            prev.next = curr.next;
        }
        //curr = curr.next;
        return A;
    }

}
