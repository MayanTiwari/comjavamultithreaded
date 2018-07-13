package interviewbit.binarysearch;

import static java.lang.System.out;

/**
 * Created by mayan on 12/7/18.
 */
//https://stackoverflow.com/questions/2177781/how-to-calculate-modulus-of-large-numbers
public class PowerFunc {
    public static void main(String[] args){
        PowerFunc powerFunc = new PowerFunc();
        out.println(powerFunc.pow(2,3,3));
    }
    public int pow(int x, int n, int d) {
        int res = power(x,n);
        return res % d;
    }
    private int power(int x,int n){
        //Base case
        if(n == 0){
            return 1;
        }
        int po = power(x,n/2);
        if(n %2 == 0){
            return po*po;
        }else{
            return x* po*po;
        }
    }
}
