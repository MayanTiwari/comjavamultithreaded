package futures;

import java.util.concurrent.Callable;

/**
 * Created by mayan on 19/11/17.
 */
public class GreeterCallable implements Callable {
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getId());
        System.out.println("The call method");
        Thread.currentThread().sleep(5000);
        return "returned from callable";
    }
}
