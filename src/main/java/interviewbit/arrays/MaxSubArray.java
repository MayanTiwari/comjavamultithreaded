package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 12/8/18.
 */
public class MaxSubArray {
    public static void main(String[] args){
        ArrayList<Integer>  integers = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        /*integers.add(1);
        integers.add(2);
        integers.add(5);
        integers.add(-7);
        integers.add(2);
        integers.add(3);*/
        integers.add(0);
        integers.add(0);
        integers.add(-1);
        integers.add(0);
        MaxSubArray maxSubArray = new MaxSubArray();
        out.println(maxSubArray.maxset(integers));
    }
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int currSum = Integer.MIN_VALUE;
        int startMax= -1;
        int endMax = -1;
        int start = 0;
        int end = 0;

        while (end < A.size()){
            if(A.get(end) > currSum){
                currSum = currSum + A.get(end);
                if(currSum > maxSum){
                    maxSum = currSum;
                    startMax = start;
                    endMax = end + 1;
                }else if(currSum == maxSum){
                    if(end+1 - start > endMax+1 - startMax){
                        startMax = start;
                        endMax = end + 1;
                    }
                }
            }else{
                start = start + 1;
                currSum = 0;
            }
            end++;
        }
        if(startMax == -1 || endMax == -1){
            return result;
        }
        for(int i = startMax ; i < endMax ; i++){
            result.add(A.get(i));
        }
        return result;
    }
}
