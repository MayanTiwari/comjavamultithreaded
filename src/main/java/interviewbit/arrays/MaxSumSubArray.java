package interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 7/8/18.
 */
public class MaxSumSubArray {
    public static void main(String[] args){
       // List<Integer> integerList = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
        List<Integer> integerList = Arrays.asList(-4,-2);
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
        out.println(maxSumSubArray.maxSubArray(integerList));
    }
    public int maxSubArray2(final List<Integer> A) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for(Integer i : A){
            maxEndingHere = maxEndingHere + i;
            if(maxEndingHere < 0) maxEndingHere = 0;
            else if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }
    public int maxSubArray(final List<Integer> A) {
        int maxSoFar = A.get(0);
        int maxEndingHere = A.get(0);
        for(int i =1; i < A.size()-1;i++){
            maxEndingHere = Math.max(A.get(i), maxEndingHere+ A.get(i));
            maxSoFar = Math.max(maxEndingHere,maxSoFar);
        }
        return maxSoFar;
    }
}
