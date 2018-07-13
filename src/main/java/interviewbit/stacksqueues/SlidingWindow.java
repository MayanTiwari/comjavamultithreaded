package interviewbit.stacksqueues;

import java.util.*;

import static java.lang.System.out;

/**
 * Created by mayan on 10/7/18.
 */

//helpful read http://techieme.in/maximum-element-sliding-window/
public class SlidingWindow {
    public static void main(String[] args){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(-1);
        integers.add(-3);
        integers.add(5);
        integers.add(3);
        integers.add(6);
        integers.add(7);
        SlidingWindow slidingWindow = new SlidingWindow();
        out.println(slidingWindow.slidingMaximum1(integers,3));

    }
    public ArrayList<Integer> slidingMaximum1(final List<Integer> A, int B) {
        ArrayList<Integer> result= new ArrayList<>(A.size());
        int n = A.size();
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for(i = 0; i < B; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && A.get(i) >= A.get(Qi.peekLast()))
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            //System.out.print(A.get(Qi.peek()) + " ");
            result.add(A.get(Qi.peek()));

            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-B)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && A.get(i)>= A.get(Qi.peekLast()))
                Qi.removeLast();
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
        // Print the maximum element of last window
        //System.out.print(A.get(Qi.peek()));
        result.add(A.get(Qi.peek()));

        return result;
    }
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result= new ArrayList<>(A.size());
        int n = A.size();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0 ; i < n;++i){
            if(!deque.isEmpty()&& deque.peekFirst() == B-i){
                    deque.poll();
            }
            while (!deque.isEmpty() && A.get(deque.peekLast()) < A.get(i)){
                deque.removeLast();
            }
            deque.offer(i);
            if(i+1 >= B){
                result.add(i+1-B,A.get(deque.peek()));
            }
        }

        return result;
    }
}
