package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.out;

/**
 * Created by mayan on 12/8/18.
 */
public class NobleInt {
    public static void main(String[] args){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(6);

        NobleInt nobleInt = new NobleInt();
        out.println(nobleInt.solve(integers));
    }
    public int solve(ArrayList<Integer> A) {
        int result = -1;
        Collections.sort(A);
        for(int i = 0; i < A.size()-1;i++){
            int count = 0;
            for(int j=i+1 ; j < A.size();j++){
                if (count > Math.abs(A.get(i))) break;
                count++;
            }
            if(count ==Math.abs(A.get(i))) {
                result = 1;
                break;
            }
        }
        return result;
    }
}
