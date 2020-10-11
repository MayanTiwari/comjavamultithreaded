package interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class PerfectPeek {
    public static void main(String[] args) {
        PerfectPeek perfectPeek = new PerfectPeek();
        List<Integer> arrayList = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
        int a = perfectPeek.perfectPeakTest(arrayList);
        System.out.println(a);
    }
    //TODO: Need to pass all test cases.
    public int perfectPeak(List<Integer> A) {
        int N = A.size();
       int[] minLeft = new int[A.size()];
       int[] maxRight = new int[A.size()];
       //fill min array
        minLeft[0] = A.get(0);
        maxRight[N-1] = A.get(N-1);
        for(int i = 1; i < N-1 ; i++){
            if(A.get(i) > minLeft[i-1]){
                minLeft[i] = A.get(i);
            }else{
                minLeft[i] = minLeft[i-1];
            }
        }
        for(int i = N-2 ; i > 0 ; i--){
            if(A.get(i) < maxRight[i+1]){
                maxRight[i] = A.get(i);
            }else{
                maxRight[i] = maxRight[i+1];
            }
        }
        for(int i =1 ; i < N -2 ; i++){
            if(A.get(i) > minLeft[i-1] && A.get(i) < maxRight[i+1]){
                return A.get(i);
            }
        }

       return -1;
    }
    //Efficient using binary search
    public int perfectPeakTest(List<Integer> A) {
        int n = A.size()-1;
        if (n == 1)
            return A.get(0);
        if (A.get(0) >= A.get(1))
            return 0;
        if (A.get(n-1) >= A.get(n-1))
            return n - 1;

        // check for every other element
        for (int i = 1; i < n - 1; i++) {
            // check if the neighbors are smaller
            if (A.get(i) >= A.get(i-1) && A.get(i) >= A.get(i + 1))
                return A.get(i);
        }
        return -1;
    }

}
