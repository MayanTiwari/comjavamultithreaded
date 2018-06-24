package interviewbit;

import static java.lang.System.out;

/**
 * Created by mayan on 15/6/18.
 */
public class NLogNSortLL {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(20);
        head1.next.next.next = new ListNode(25);
        head1.next.next.next.next = new ListNode(15);
        head1.next.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next.next = new ListNode(7);
        ListNode.printLL(head1);
        NLogNSortLL nLogNSortLL = new NLogNSortLL();
        nLogNSortLL.sortList(head1);
    }

    public ListNode sortList(ListNode A) {
        //base case
        if(A== null || A.next== null){
            return null;
        }
        ListNode middleElement = getMiddleElement(A);
        ListNode nextOfMiddle = middleElement.next;
        middleElement.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(nextOfMiddle);
        //merge left and right
        ListNode listNode = mergerecusive(left,right);
        return listNode;
    }

    private ListNode getMiddleElement(ListNode head) {
        //Base case.
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

 /*   private ListNode merge(ListNode left, ListNode right) {
        ListNode mHead;
        ListNode tail;
        ListNode leftCurr = left;
        ListNode rightCurr = right;
        if (leftCurr.val < rightCurr.val) {
            mHead = tail = leftCurr;
            leftCurr = leftCurr.next;

        } else {
            mHead = tail = right;
            rightCurr = rightCurr.next;
        }
        while (true) {
            while (leftCurr.next != null && leftCurr.val < rightCurr.val) {
                tail.next = leftCurr;
                tail = tail.next;
                leftCurr = leftCurr.next;
            }
            while (rightCurr.next != null && rightCurr.val < leftCurr.val) {
                tail.next = rightCurr;
                tail = tail.next;
                rightCurr = rightCurr.next;
            }
            if (leftCurr == null && rightCurr == null) {
                break;
            }
        }
        return mHead;
    }*/
    private ListNode mergerecusive(ListNode left,ListNode right){
        ListNode result;
        //Base case
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.val < right.val){
            result = left;
            result.next = mergerecusive(left.next,right);
        }else{
            result = right;
            result.next = mergerecusive(left,right.next);
        }
        return result;

    }

}
