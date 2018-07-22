package interviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mayan on 16/7/18.
 */
//REFERED CCI
public class RotatedArray {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(4,5,6,7,0,1,2);
    }
    public int search(final List<Integer> a, int b) {

        //we need to apply custom binary search
        int start = 0;
        int end = a.size();

        while(start < end ){
            int mid = (start+end)/2;
            if(a.get(mid) == b){
                return mid;
            }else if(a.get(mid) > b && a.get(start) < a.get(mid)){
                end = mid -1;
            }//else if(a.get(mid) > b  && )
        }

        return 0;
    }

}
