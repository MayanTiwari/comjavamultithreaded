package interviewbit.stacksqueues;

import java.util.Stack;

/**
 * Created by mayan on 11/7/18.
 */
public class MinStack {

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> regularStack = new Stack<>();

    public void push(int x) {
        regularStack.push(x);
        if(!minStack.isEmpty()&& minStack.peek() > x){
            minStack.push(x);
        }
    }

    public void pop() {
        int temp = 0;
        if(!regularStack.isEmpty()){
            temp = regularStack.pop();
        }
        if(!minStack.isEmpty()&& minStack.peek() == temp){
            minStack.pop();
        }
    }

    public int top() {
        if(!regularStack.isEmpty()){
            return regularStack.pop();
        }else{
            return -1;
        }
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }else{
            return -1;
        }
    }
}
