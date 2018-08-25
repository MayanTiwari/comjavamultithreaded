package interviewbit.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

/**
 * Created by mayan on 15/8/18.
 * 'll solve the question of n+1 numbers in a stream of numbers between 1 to n in two passes and O(sqrt(n)) space.

 Split the numbers from 1 to n in sqrt(n) ranges so that range i corresponds to [sqrt(n) * i .. sqrt(n) * (i + 1)).
 Do one pass through the stream of numbers and figure out how many numbers fall in each of the ranges.
 At least one of the ranges will contain more than sqrt(n) elements.
 Do another pass and process just those elements in the oversubscribed range.
 Using a hash table to keep frequencies you'll find a repeated element.

 This is O(sqrt(n)) memory and 2 sequential passes through the stream.
 */
public class FindDupe {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(3,4,1,4,1);
        FindDupe findDupe = new FindDupe();
        findDupe.repeatedNumber(integerList);
      /*  out.println((int)Math.ceil(5.1));
        out.println((int)Math.ceil(5));

        out.println((int)Math.floor(5.9));
        out.println((int)Math.floor(5));*/
    }
    private int[] buckets;

    private int AVG_BUCKET_SIZE = 0;

    private int LAST_BUCKET_SIZE = 0;

    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> A) {
        int n = A.size() - 1; // [1 : n] for (n + 1) number
        if (n < 1) {
            // no way to find duplicates
            return -1;
        }
        int nBuckets = (int) Math.ceil(Math.sqrt(n)); // ceiling of sqrt(n)
        int range = (int) Math.sqrt(n); // floor of sqrt(n)

        buckets = new int[nBuckets];
        if (range * nBuckets < n) {
            // enlarge range of each bucket to contain all elements
            range++;
        }

        LAST_BUCKET_SIZE = n - (nBuckets - 1) * range;

        AVG_BUCKET_SIZE = range;

        int targetBucket = -1;
        for (int num : A) {
            int iBucket = (num - 1) / range;
            buckets[iBucket]++;
            if (moreThanExpected(iBucket)) {
                // once we found a bucket holding more elements than expected
                targetBucket = iBucket;
                break;
            }
        }
        if (targetBucket != -1) {
            Set<Integer> targetSet = new HashSet<>();
            int lower = targetBucket * range + 1;
            int upper = lower + range - 1;
            for (int num : A) {
                if (num >= lower && num <= upper && !targetSet.add(num)) {
                    // duplicate found
                    return num;
                }
            }
        }
        return -1;
    }

    // whether bucket[n] has more than expected elements
    private boolean moreThanExpected(int nBucket) {
        if (nBucket == buckets.length - 1) {
            return buckets[nBucket] > LAST_BUCKET_SIZE;
        } else {
            return buckets[nBucket] > AVG_BUCKET_SIZE;
        }
    }
}
