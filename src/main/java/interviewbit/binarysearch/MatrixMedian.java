package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.out;

/**
 * Created by mayan on 15/7/18.
 */
public class MatrixMedian {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        arrayListArrayList.add(l1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(6);
        l2.add(9);
        arrayListArrayList.add(l2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(3);
        l3.add(6);
        l3.add(9);
        arrayListArrayList.add(l3);

        MatrixMedian matrixMedian = new MatrixMedian();
        out.println(matrixMedian.findMedian(arrayListArrayList));
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //Find min and max of matrix
        for (ArrayList<Integer> item : A){
            if(min > item.get(0)){
                min = item.get(0);
            }
            if(max < item.get(item.size()-1)){
                max = item.get(item.size()-1);
            }
        }
        int desired = (A.get(0).size()* A.size()+1)/2;

        while(min < max){
            int mid = (min + max)/2;
            int place = 0;
            int get = 0;
            for(ArrayList<Integer> item : A){
                get = Collections.binarySearch(item,mid);
                if(get < 0){
                    get = Math.abs(get) -1;
                }else{
                    while(get < item.size() && item.get(get)== mid){
                        get+=1;
                    }
                }
                place = place + get;
            }
            if(place < desired){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }
}
