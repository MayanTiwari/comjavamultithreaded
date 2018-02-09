import futures.ExecService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by mayan on 19/11/17.
 * Runnable
 * Callable
 * return values
 * Exceptions/delegate exceptions /catch exceptions
 * Interruptions and cancellations
 * Extend Executor behaviours
 */

public class MultiThreadingTests {
    private RealHelloWorldMultiThread realHelloWorldMultiThread;
    private ExecService exec ;
    @Before
    public void setup(){
        this.exec = new ExecService();
        this.realHelloWorldMultiThread = new RealHelloWorldMultiThread();
    }
    @Test
    public void callableTest() throws ExecutionException, InterruptedException {
        this.realHelloWorldMultiThread.callable();
    }
    @Test
    public void runnableTest(){
        RealHelloWorldMultiThread.runnable();
        Assert.assertTrue(true);
    }
    @Test
    public void executorServiceTestRunnable(){
        exec.runThisTaskWithExec();
    }
    @Test
    public void executorServiceTestCallable() throws InterruptedException,ExecutionException{
        exec.execCallable();
    }
}
