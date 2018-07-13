package cyclicbarrierandcountdownlatch;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by mayan on 8/7/18.
 */
public class Computation1 implements Runnable{
    public static int product = 0;
    public void run()
    {
        product = 2 * 3;
        try
        {
            Tester.newBarrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }
}
