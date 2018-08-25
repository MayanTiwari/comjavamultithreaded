package futures.notification;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by mayan on 3/8/18.
 */
public class CustomTask extends FutureTask<String> {

    CallBack callBack;
    public CustomTask(Callable<String> callable,CallBack callBack ) {
        super(callable);
        this.callBack = callBack;
    }

    @Override
    protected void done() {
        super.done();
        this.callBack.notified();
    }
}
