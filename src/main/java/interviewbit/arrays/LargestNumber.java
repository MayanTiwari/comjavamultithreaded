package interviewbit.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 12/8/18.
 */
public class LargestNumber {
    public static void main(String[] args){
        //List<Integer> list = Arrays.asList(3,30,34,5,9);
        List<Integer> list = Arrays.asList(0,0,0,0);
        LargestNumber largestNumber = new LargestNumber();
        out.println(largestNumber.largestNumber(list));
    }
    public String largestNumber(final List<Integer> A) {
        StringBuilder stringBuilder = new StringBuilder();
       /* Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer X, Integer Y) {
                // first append Y at the end of X
                String XY=X.toString() + Y.toString();

                // then append X at the end of Y
                String YX=Y.toString() + X.toString();

                // Now see which of the two formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1:1;

            }
        });*/
        Collections.sort(A, (X,Y) -> {
                // first append Y at the end of X
                String XY=X.toString() + Y.toString();
                // then append X at the end of Y
                String YX=Y.toString() + X.toString();
                // Now see which of the two formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1:1;
            }
        );
        for(Integer i : A){
            stringBuilder.append(i.toString());
        }

        Long res = Long.parseLong(stringBuilder.toString());
        return res.toString();
    }
    private int getRightMostValue(int n){
        while (n / 10 > 10 ){
            n /= 10;
        }
        return n;
    }
}
