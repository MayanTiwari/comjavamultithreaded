package futures;

import java.math.BigInteger;

/**
 * Created by mayan on 19/11/17.
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {

    public BigInteger compute(String arg) throws InterruptedException {
        Thread.currentThread().sleep(5000);
        return new BigInteger(arg);
    }
}
