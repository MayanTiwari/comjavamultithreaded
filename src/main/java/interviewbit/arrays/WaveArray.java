package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.out;

/**
 * Created by mayan on 13/8/18.
 */
public class WaveArray {
    public static void main(String[] args){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        WaveArray waveArray = new WaveArray();
        out.println(waveArray.wave(integers));
    }
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        for(int i=0;i<A.size();i=i+2){
            // If current even element is smaller
            // than previous
            if (i>0 && A.get(i-1) > A.get(i) )
                Collections.swap(A,i-1,i);

            // If current even element is smaller
            // than next
            if (i<A.size()-1 && A.get(i)< A.get(i+1) )
                Collections.swap(A,i,i+1);

        }
        return A;
    }
}
