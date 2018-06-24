package interviewbit;

/**
 * Created by mayan on 16/6/18.
 */
public class KReverseLL {
    /*private class Result{
        ListNode head,tail;
    }*/
    static ListNode head;
    public static void main(String[] args){
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
       head.next.next.next = new ListNode(4);
       head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
        //ListNode.printLL(headfirst);
        KReverseLL kReverseLL = new KReverseLL();
        //kReverseLL.reverse(headfirst);
        //ListNode.printLL(kReverseLL.reverse(headfirst));
        ListNode result = kReverseLL.reverseList(head);
        ListNode.printLL(result);
    }
    public ListNode reverseList(ListNode A) {
       // if(A == null) return null;
        ListNode prev = null;
        ListNode curr = A;
        ListNode nextNode= null;
        int count = 0;
        while(count < 2 && curr !=null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr ;
            curr = nextNode;
            count++;
        }
        if(nextNode !=null){
            head.next =reverseList(nextNode);
            ListNode.printLL(head);
        }
        return prev;
    }

    private ListNode reverse(ListNode head,int k){
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while(curr !=null && count < k ){
            ListNode listNode = curr.next;
            curr.next = prev;
            prev = curr ;
            curr = listNode;
        }
        return prev;
    }
}
