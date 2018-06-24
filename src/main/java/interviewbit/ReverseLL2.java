package interviewbit;

import java.util.Optional;

/**
 * Created by mayan on 17/6/18.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.
 */
public class ReverseLL2 {
    class Result{
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ReverseLL2 reverseLL2 = new ReverseLL2();
        ListNode.printLL(head);
        ListNode.printLL(reverseLL2.reverseBetween(head,2,4));

    }
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode curr = A;
        ListNode prev = null;
        int count = 0;
        while (count < B){
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode listNode = curr;
        ListNode theHead = reverse(curr,C-B);
        prev.next = theHead;
        return A;
    }
    private ListNode reverse(ListNode head,int c){
        ListNode prev = null;
        ListNode curr = head;
        ListNode tail = curr;
        int count = 0;
        while(curr !=null && count < c){
            ListNode listNode = curr.next;
            tail.next = listNode;
            curr.next = prev;
            prev = curr ;
            curr = listNode;
            count++;
        }
        return prev;
    }
}
