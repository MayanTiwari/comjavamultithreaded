package interviewbit;

/**
 * Created by mayan on 9/6/18.
 */
public class MergeLL {
    public static void main(String[] args){
        MergeLL mergeLL = new MergeLL();
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
       head1.next.next = new ListNode(20);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(15);

        ListNode.printLL(head1);
        ListNode.printLL(head2);

        ListNode listNode =  mergeLL.mergeTwoLists(head1,head2);
        ListNode.printLL(listNode);

    }
   /* public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null && B == null) return null;
        if(A == null) return B;
        if(B == null) return A;
        ListNode head;
        ListNode small = A.val < B.val ? A: B;
        ListNode large = A.val > B.val ? A: B;
        head = small;
        while(small.next !=null && large.next !=null){
            if(small.next.val > large.next.val){
                while(large.next.val < small.next.val){
                    head.next = large.next;
                    large = large.next;
                    head = head.next;
                    }
            }else{
                head.next = small.next;
                small = small.next;
                head = head.next;
            }
        }
        return head ;
    }*/
   public ListNode mergeTwoLists(ListNode A, ListNode B) {
       ListNode dummy = null;
       ListNode dHead = null;
       ListNode one = A;
       ListNode two = B;
       //acccess both the list
       while(one !=null || two!=null){
           if(one !=null && two!=null){
               if(one.val < two.val){
                   if(dummy == null){
                       dummy = dHead = one;
                   }else{
                       dummy.next = one;
                       dummy = dummy.next;
                   }
                   one = one.next;
               }else{
                   if(dummy == null){
                       dummy = dHead = two;
                   }else{
                       dummy.next = two;
                       dummy = dummy.next;
                   }
                   two = two.next;
               }
           }else if(one == null){
               if(dummy == null){
                   dummy = dHead = two;
               }else{
                   dummy.next = two;
                   dummy = dummy.next;
               }
               two = two.next;

           }else if(two == null){
               if(dummy == null){
                   dummy =dHead = one;
               }else{
                   dummy.next = one;
                   dummy = dummy.next;
               }
               one = one.next;
           }


       }
       return dHead == null ? new ListNode(0) : dHead;
   }
}
