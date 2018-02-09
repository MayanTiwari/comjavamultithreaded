package futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by mayan on 19/11/17.
 */
public class PreLoader {
    private final FutureTask<ProductInfo> futureTask = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        public ProductInfo call() throws Exception {
            return load();
        }
    });

    private final Thread thread = new Thread(futureTask);

    private ProductInfo load() throws InterruptedException {
        Thread.currentThread().sleep(5000);
        return new ProductInfo();
    }
    public void start(){
        this.thread.start();
    }
    public ProductInfo get() throws ExecutionException, InterruptedException {
        return futureTask.get();
    }

}
