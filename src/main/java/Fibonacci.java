import static java.lang.System.out;

/**
 * Created by mayan on 10/8/18.
 */
public class Fibonacci {
    public static void main(String[] args){
        int res = fibo(5);
        out.println(res);
    }
    public static int fibo(int n){
        if(n == 0){
            return 1;
        }else if(n <=0){
            return 0;
        }else{
            int sum = fibo(n-1) + fibo(n-2);
           // out.println(sum);
            return sum;
        }
    }
}
