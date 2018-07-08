package interviewbit.stacksqueues;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.out;

/**
 * Created by mayan on 24/6/18.
 */
public class EvaluateExpression {
    public static void main(String[] args){
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("2");
        strings.add("2");
        strings.add("/");
       // strings.add("3");
       // strings.add("*");
        int res = evaluateExpression.evalRPN(strings);
        out.println(res);
    }
    /*public int evalRPN(ArrayList<String> A) {
        Stack<String> operatorStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();

        //Push values to value stack and operation stack.
        for(String s : A){
            if(isOperator(s))
            operatorStack.push(s);
            else{
                integerStack.push(Integer.parseInt(s));
            }
        }
        return cal(operatorStack,integerStack);
    }*/
    public int evalRPN(ArrayList<String> A) {
        Stack<String> operatorStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();

        //Push values to value stack and operation stack.
        for(String s : A){
            if(isOperator(s)){
                if(!integerStack.isEmpty()){
                    int val1 = integerStack.pop();
                    int val2 = integerStack.pop();
                    int val3 = evaluate(s,val1,val2);
                    integerStack.push(val3);
                }
            }else{
                integerStack.push(Integer.parseInt(s));
            }
        }
        if(!integerStack.isEmpty()){
            return integerStack.pop();
        }else{
            return -1;
        }
    }
    private int cal(Stack<String> op,Stack<Integer> val){
        //Base case
        if(val.isEmpty()){
            return 0;
        }
        int val1 = val.pop();
        int val2 = cal(op,val);
        return evaluate(op.pop(),val1,val2);
    }
    private static int evaluate(String operator,int a,int b){
        int result = 0;
        switch (operator){
            case "+":
                result = a + b;
                break;
            case "-":
                result  = a-b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if(b !=0){
                    result = a / b;
                }
                break;
        }
        return result;
    }
    private static boolean isOperator(String input){
        if(input == "+" || input == "*"
                || input == "-" || input == "/")
            return true;
        else return false;
    }
}

