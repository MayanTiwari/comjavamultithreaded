package interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mayan on 18/8/18.
 */
public class MinGap {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(5, 3, 1, 8, 9, 2, 4);
        MinGap minGap = new MinGap();
        minGap.maximumGap(integerList);
    }
    public int maximumGap(final List<Integer> A) {
        if(A.size() < 2){
            return 0;
        }
        int n = A.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //Get min and max.
        for(Integer i : A){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        //n-1 buckets -  we only care about max and min in each buckets
        int[] bucketMaxima = new int[n-1];
        Arrays.fill(bucketMaxima, Integer.MIN_VALUE);
        int[] bucketMinima = new int[n-1];
        Arrays.fill(bucketMinima, Integer.MAX_VALUE);
        //bucket width
        float delta = (float)(max-min)/((float)n-1);

        //populate the bucket maxima and minima
        for(int i = 0; i < n; i++){
            if(A.get(i) == max || A.get(i) == min){
                continue;
            }
            int bucketIndex = (int) Math.floor((A.get(i)-min)/delta);
            bucketMaxima[bucketIndex] = bucketMaxima[bucketIndex] == Integer.MIN_VALUE
                    ? A.get(i) :
                    Math.max(bucketMaxima[bucketIndex], A.get(i));

            bucketMinima[bucketIndex] = bucketMinima[bucketIndex] ==Integer.MAX_VALUE
                    ? A.get(i)
                    : Math.min(bucketMinima[bucketIndex], A.get(i));
        }
        //find the maxgap - maxgaps
        int prev =  min;
        int maxGap = 0;
        for(int i = 0; i< n-1; i++){
            //empty bucket according to Pigeonhole principle
            if(bucketMinima[i] == Integer.MAX_VALUE){
                continue;
            }

            maxGap = Math.max(maxGap, bucketMinima[i]-prev);
            prev = bucketMaxima[i];
        }
        maxGap = Math.max(maxGap, max-prev);
        return maxGap;
    }
}
