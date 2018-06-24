package interviewbit;

/**
 * Created by mayan on 13/6/18.
 */
public class PartitionLL {
    public static void main(String[] args){
        PartitionLL partitionLL = new PartitionLL();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        ListNode node = partitionLL.partition(head1,3);
        ListNode.printLL(node);
        System.exit(0);
    }
    public ListNode partition(ListNode A, int B) {
        ListNode pelement = null;
        ListNode curr = A;
        ListNode less = null;
        ListNode more = null;
        ListNode anotherHead = null;
        curr = A;
        while(curr !=null){
            if(curr.val != B) {
                if(curr.val < B){
                    if(less == null){
                        less = curr;
                        A = curr;
                    }else{
                        less.next = curr;
                        less = less.next;
                    }
                }else{
                    if (more == null) {
                        more = curr;
                        anotherHead = more;
                    }else{
                        more.next = curr;
                        more = more.next;
                    }
                }
            }else{
                pelement = curr;
            }
            curr = curr.next;
        }
        if(less !=null) {
            less.next = pelement;
        }
        if(more !=null){
            more.next = null;
        }
        pelement.next = anotherHead;
        return A;
    }
}
