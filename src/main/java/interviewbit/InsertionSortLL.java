package interviewbit;



import static java.lang.System.out;

/**
 * Created by mayan on 14/6/18.
 */
public class InsertionSortLL {

    public static void main(String[] args){
        int[] arr = {1,5,2,7,8,2};
        int n = arr.length;
       /* for(int i=1;i< arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j -1;
            }
            arr[j+1]= key;
        }

        for(int a : arr){
            out.println(a);
        }*/
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(4);
        //ListNode.printLL(head1);
        InsertionSortLL insertionSortLL = new InsertionSortLL();
        ListNode node= insertionSortLL.insertionSortList(head1);
        ListNode.printLL(node);

    }
    public ListNode insertionSortList(ListNode A) {
        ListNode sortedHead  = null;
        ListNode current = A;
        while (current!=null){
            ListNode next  = current.next;
            sortedHead = sortList(current,sortedHead);
            current = next;
        }
        A = sortedHead;
        return A;
    }
    private ListNode sortList(ListNode newNode, ListNode sortedHead){
        if(sortedHead == null || sortedHead.val >= newNode.val ){
            newNode.next =sortedHead;
            sortedHead = newNode;
        }else{

            ListNode curr = sortedHead;
            while(curr.next!=null && curr.next.val < newNode.val){
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return sortedHead;
    }

}
