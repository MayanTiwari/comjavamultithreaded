package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 8/8/18.
 */
public class AbsMaxDiff {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1,3,-1);
        AbsMaxDiff absMaxDiff = new AbsMaxDiff();
        out.println(absMaxDiff.maxArr(integerList));
    }
    public int maxArrBF(List<Integer> A) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i < A.size();i++){
            for(int j =i;j< A.size();j++){
                if(i ==j) continue;
                out.println(i + ":" + j);
                int temp = Math.abs(A.get(i)-A.get(j)) + Math.abs(i-j);
                if(temp> max){
                    max = temp;
                }
            }
        }
        return max;
    }
    public int maxArr(List<Integer> A) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=0;i < A.size();i++){
            max1 = Math.max(max1,A.get(i) + i);
            min1 = Math.min(min1,A.get(i)+ i);
            max2 = Math.max(max2,A.get(i)-1);
            min2 = Math.min(min2,A.get(i) -1);

        }
        return Math.max(max1 - min1,max2 - min2);
    }
}
