package interviewbit.stacksqueues;

import java.util.Stack;

/**
 * Created by mayan on 20/6/18.
 */
public class RedundentBraces {
    public static void main(String[] args){
        RedundentBraces redundentBraces = new RedundentBraces();
        redundentBraces.braces("");

    }
    public int braces(String A) {
        String input = "(a+(a+b))";
        Stack<Character> s = new Stack<>();
        for(int i=0; i<input.length();i++){
            Character test = input.charAt(i);
            if(input.charAt(i) == ')'){
                while(!s.isEmpty() && s.peek() != '('){
                    s.pop();
                }
                s.pop();
                if(s.peek() == '(') return 0;
                s.push('a');
            }else {//if(input.charAt(i) == '(' || isOperator(input.charAt(i))){
                s.push(input.charAt(i));
            }//else {
               // return 0;
           // }
        }
        if(s.size() == 1) return 1;

        return 0;
    }
    private static boolean isOperator(Character input){
        if(input == '+' || input == '*'
                || input == '-' || input == '/')
            return true;
        else return false;
    }
}
