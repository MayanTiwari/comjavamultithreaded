package futures.completedfutures;

import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by mayan on 1/8/18.
 */
public class MyFutureTask<String> extends FutureTask<String> {
    public MyFutureTask(Callable<String> callable) {
        super(callable);
    }

    @Override
    public boolean isDone() {
        return super.isDone();
    }
}
