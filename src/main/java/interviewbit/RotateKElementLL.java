package interviewbit;

/**
 * Created by mayan on 10/6/18.
 */
public class RotateKElementLL {
    public static void main(String[] args){
        RotateKElementLL rotateKElementLL = new RotateKElementLL();
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(20);
        head1.next.next.next = new ListNode(25);
        ListNode.printLL(head1);
        ListNode newHead = rotateKElementLL.rotateRight(head1,12);
        ListNode.printLL(newHead);

    }
    public ListNode rotateRight(ListNode A, int B) {
        ListNode runner = A;
        ListNode curr = A;
        ListNode prev = null;
        ListNode first = A;
        ListNode extra = A;
        //Move runner to nth location
        for(int i = 1; i < B && runner.next!=null; i++ ){
            extra = runner;
            runner = runner.next;

        }
        //Make curr and runner n distance appart.
        while(runner.next !=null){
            prev = curr;
            curr = curr.next;
            runner = runner.next;
        }
        if(prev != null){
            //Set null (end) to previous item.
            prev.next =null;
            runner.next = first;
            A = curr;
        }else{// rotate last element.
            extra.next = null;
            runner.next =first;
            A = runner;
        }

        return A;
    }

}
