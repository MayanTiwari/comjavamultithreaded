package interviewbit.binarysearch;

import static java.lang.System.out;

/**
 * Created by mayan on 15/7/18.
 */
public class SquareRoot {
    public static void main(String[] args){
        SquareRoot squareRoot = new SquareRoot();
        out.println(squareRoot.sqrt(930675566));
        out.println(Integer.MAX_VALUE);
        out.println(Integer.MIN_VALUE);

        out.println(Long.MAX_VALUE);
        out.println(Float.MAX_VALUE);

    }
    public int sqrt(int a) {
        if(a < 1) return 0;
        if(a == 1) return 1;
        long start = 1;
        long end = a>=2 ? a /2 : a;
        int result=0;
        while(start <= end){
            long mid = (start + end)/2;
            if(mid * mid == a){
                return (int)mid;
            }else if(mid * mid < a){
                start = mid + 1;
                result = (int)mid;
            }else if(mid * mid > a){
                end = mid -1;

            }
        }
        return result;

    }
}
