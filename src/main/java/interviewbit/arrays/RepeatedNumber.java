package interviewbit.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mayan on 12/8/18.
 */
public class RepeatedNumber {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(3,1,2,5,3);
    }
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        long actualSum = n*(n+1)/2;
        long actualProduct = getActualProduct(n);
        long sum =0;
        long product = 0;
        for(int i =0; i < n;i++){
            sum += A.get(i);
            product *= A.get(i);
        }

        return null;
    }
    public long getActualProduct(int n){
        long result = 0;
        for(int i =1; i <= n;i++){
            result = result*i;
        }
        return result;
    }
}
