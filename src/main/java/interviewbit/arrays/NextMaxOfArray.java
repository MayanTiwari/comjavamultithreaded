package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextMaxOfArray {
    public static void main(String[] args) {
        int arr[]= {11, 13, 21, 3};
        int arrp[] = {9,8,7,6,5,4,3,2,1};
        //printNGE(arrp, n);
        //printNGE_BF(arr,n);
        printNSE(arr,arr.length);
    }
    //O(n2)
    private static void printNGE_BF(int[] arr, int n) {
        List<Integer> integers = new ArrayList<>();
        //BF approach.
        for(int i = 0 ; i < n ; i++){
            boolean hasValue = false;
            for(int j = i + 1; j <= arr.length -1; j++){
                if(arr[i] < arr[j]){
                    integers.add(arr[j]);
                    hasValue = true;
                    break;
                }
            }
            if(!hasValue){
                integers.add(-1);
            }
        }
        integers.forEach(System.out::println);
    }

    private static void printNGE(int[] arr, int n) {
        List<Integer> integers = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1 ; i < n ; i++){
             while (!stack.isEmpty() && stack.peek() < arr[i]){
                 System.out.println(arr[i]);
                 stack.pop();
             }
             stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            System.out.println(-1);
            stack.pop();
        }
        integers.forEach(System.out::println);
    }
    private static void printNSE(int[] arr, int n) {
        List<Integer> integers = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1 ; i < n ; i++){
            while (!stack.isEmpty() && stack.peek() > arr[i]){
                System.out.println(arr[i]);
                stack.pop();
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            System.out.println(-1);
            stack.pop();
        }
        integers.forEach(System.out::println);
    }
}
