package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class NextMaxOfArray {
    public static void main(String[] args) {
        int arr[]= {11, 13, 21, 3};
        int n = arr.length;
        printNGE(arr, n);
    }
    private static void printNGE_BF(int[] arr, int n) {
        List<Integer> integers = new ArrayList<>();
        //BF approach.
        for(int i = 0 ; i <= arr.length -1 ; i++){
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
        for(int i = 0 ; i <= arr.length -1 ; i++){
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
}
