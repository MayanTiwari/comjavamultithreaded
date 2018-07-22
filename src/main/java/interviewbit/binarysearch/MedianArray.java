package interviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 15/7/18.
 */
public class MedianArray {
    public  static void main(String[] args){
        List<Integer> A = Arrays.asList(1,4,5);
        List<Integer> B = Arrays.asList(2,4);
        MedianArray medianArray = new MedianArray();
        out.println(medianArray.findMedianSortedArrays(A,B));

    }
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(a.size() > b.size() ){
            return findMedianSortedArrays(b,a);
        }
        int x = a.size();
        int y = a.size();
        int low=0;
        int high = x;

        while(low < high){
            int partitionX = (low + high)/2;
            int partitionY= (x+ y +1)/2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : a.get(partitionX-1);
            int minRightX = partitionX == 0 ? Integer.MIN_VALUE : a.get(partitionX);

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : b.get(partitionY -1);
            int minRightY = partitionY == 0 ? Integer.MIN_VALUE : b.get(partitionY);

            if(maxLeftX <=minRightY && maxLeftY <= minRightX){
                if((x+y) % 2 == 0){
                    return ((double)Math.max(maxLeftX,maxLeftY)+ Math.min(minRightX,minRightY)/2);
                }else{
                    return (double)Math.max(maxLeftX,maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                high = partitionX -1;
            }else{
                low = partitionX +1;
            }
        }
        return 0;
    }
}
