package interviewbit.binarysearch;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by mayan on 19/7/18.
 */
public class SortedInsertedPosition {
    public static void main(String[] args){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(6);
        SortedInsertedPosition sortedInsertedPosition = new SortedInsertedPosition();
        out.print(sortedInsertedPosition.searchInsert(integers,2));
    }
    public int searchInsert(ArrayList<Integer> a, int b) {
        int low =0 ;
        int high = a.size();
        int currIndex = 0;

        while (low < high){
            int mid = (low + high)/2;
            if(a.get(mid) == b){
                return mid;
            }else if(a.get(mid) < b){
                low = mid+1;
                currIndex = mid;

            }else if(a.get(mid) > b){
                high = mid-1;
                currIndex = mid;
            }
        }
        return currIndex +1;

    }
}
