package interviewbit.stacksqueues;

import java.util.*;

import static java.lang.System.out;

/**
 * Created by mayan on 29/6/18.
 */
public class RainWater {
    public static void main(String[] args){
        List<Integer> A = new ArrayList<>();
        HashSet<Integer> integers = new HashSet<>();
        A = Arrays.asList(1,0,2,1,0,1,3,2,1,2,1);
        A.forEach(out::println);
        //out.println(integerList.stream().reduce(Integer::max));

        int ans = 0;
        Stack<Integer> integerStack = new Stack<>();
        int curr = 0 ;
        int size = A.size();
        while(curr < size){
            while(!integerStack.isEmpty() && A.get(curr) > A.get(integerStack.peek())){
                int top = integerStack.peek();
                integerStack.pop();
               // if(integerStack.isEmpty()) break;
                int distance = curr - top -1;
                int bounded_height = Math.min(A.get(curr),A.get(top)) - A.get(top);
                ans += distance * bounded_height;
            }
            integerStack.push(A.get(curr++));
        }
    }
}
