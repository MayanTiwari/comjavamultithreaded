package interviewbit;

import static java.lang.System.out;

/**
 * Created by mayan on 3/6/18.
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x; next = null;
    }
    public static void printLL(ListNode head){
        StringBuilder stringBuilder = new StringBuilder();
        while(head!=null){
            stringBuilder.append(head.val+ "; ");
            head = head.next;
        }
        out.println(stringBuilder.toString());
    }
}
