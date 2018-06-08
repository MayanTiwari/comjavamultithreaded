package datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.System.out;

/**
 * Created by mayan on 13/5/18.
 */
public class JavaHeap {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((x,y) -> x -y);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
    public static void main(String[] args){
        JavaHeap javaHeap = new JavaHeap();
        //javaHeap.addRandomNumber(10);
        javaHeap.getMedian();
    }
    private void addRandomNumber(int randomNumber){
        if(maxHeap.size() == minHeap.size()){
            if(maxHeap.peek() !=null && randomNumber > minHeap.peek()){
                maxHeap.offer(minHeap.peek());
            }
        }
    }
    private Integer getMedian(){
        maxHeap.offer(10);
        maxHeap.offer(3);
        maxHeap.offer(5);
        maxHeap.offer(8);
        maxHeap.offer(12);


        this.maxHeap.forEach(out::println);
        return 0;

    }
}
