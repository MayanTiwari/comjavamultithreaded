package interviewbit.stacksqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static java.lang.System.out;

/**
 * Created by mayan on 8/7/18.
 */
public class NearestSmall {
    public static void main(String[] str){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(5);
        integers.add(2);
        integers.add(10);
        integers.add(8);
        NearestSmall nearestSmall = new NearestSmall();
        ArrayList<Integer> result=  nearestSmall.prevSmaller(integers);
        out.println(result);


    }
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<Integer> integerStack = new Stack<>();
        for (Integer i : A){
            while(!integerStack.isEmpty() && integerStack.peek() >= i){
                integerStack.pop();
            }
            if(integerStack.isEmpty()){
                integers.add(-1);
            }else{
                integers.add(integerStack.peek());
            }
            integerStack.push(i);
        }
        return integers;

    }
}
