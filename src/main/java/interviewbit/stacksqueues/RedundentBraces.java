package interviewbit.stacksqueues;

import java.util.Stack;

import static java.lang.System.out;

/**
 * Created by mayan on 20/6/18.
 */
public class RedundentBraces {
    public static void main(String[] args){
        RedundentBraces redundentBraces = new RedundentBraces();
        out.println(redundentBraces.braces(""));

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
                if(s.size()>0){
                    s.pop();
                }
                if(s.size()> 0 && s.peek() == '(') return 1;
                s.push('a');
            }else {//if(input.charAt(i) == '(' || isOperator(input.charAt(i))){
                s.push(input.charAt(i));
            }//else {
               // return 0;
           // }
        }
        if(s.size() == 1) return 0;

        return 1;
    }
    private static boolean isOperator(Character input){
        if(input == '+' || input == '*'
                || input == '-' || input == '/')
            return true;
        else return false;
    }
}
