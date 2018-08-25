package interviewbit.arrays;

import java.util.*;

import static java.lang.System.out;

/**
 * Created by mayan on 15/8/18.
 */
public class MaxDist {
    private class Item{
        int index;
        int value;

        public Item(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(3,5,4,2);
        MaxDist maxDist = new MaxDist();
        out.println(maxDist.maximumGapOptimized(integerList));
    }
    public int maximumGap(final List<Integer> A) {
        int maxDiff = 0;

        for(int i =0; i < A.size();i++){
            for(int j =i+1; j < A.size();j++){
                if(A.get(j) >= A.get(i)){
                    if(j-i > maxDiff){
                        maxDiff = j-i;
                    }
                }
            }
        }
        return maxDiff;
    }
    public int maximumGapOptimized(final List<Integer> A) {
        int maxDiff = -1;
        List<Integer> lMin = new ArrayList<>(A);
        List<Integer> rMax = new ArrayList<>(A);
        lMin.set(0,A.get(0));

        for(int i=1;i<A.size();i++){
            lMin.set(i,Math.min(A.get(i),lMin.get(i-1)));
        }
        rMax.set(0,A.get(A.size()-1));
        for(int j = A.size()-2;j>=0;j--){
            rMax.set(j,Math.max(A.get(j),rMax.get(j+1)));
        }
        int i = 0,j=0;
        while (i < A.size() && j < A.size()){
            if(lMin.get(i) < rMax.get(j)){
                maxDiff = Math.max(maxDiff,j-i);
                j = j+1;
            }else{
                i = i+1;
            }
        }
        return maxDiff;
    }
}
