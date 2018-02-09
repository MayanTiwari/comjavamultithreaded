import java.util.concurrent.TimeUnit;
import  static java.lang.System.out;
/**
 * Created by mayan on 22/10/17.
 */
public class SleepTimeouts {
    public static void main(String[] args) throws InterruptedException {
        int val = 3;
        System.out.println("Sleeping for " + val + "us");
        TimeUnit.MICROSECONDS.sleep(val);

        String s =  "ABCD";
        out.println(s.charAt(3));


    }
}
