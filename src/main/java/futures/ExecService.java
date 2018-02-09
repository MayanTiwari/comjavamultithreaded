package futures;

import javax.sound.midi.SysexMessage;
import java.util.concurrent.*;

/**
 * Created by mayan on 14/1/18.
 */
public class ExecService {
    ExecutorService exeCached = Executors.newCachedThreadPool();

    class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("From runnable");
            System.out.println(Thread.currentThread().getId());
        }
    }
    class CallableTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "from callable";
        }
    }

    public void  runThisTaskWithExec() {
        exeCached.execute(new RunnableTask());
    }
    public void  execCallable() throws ExecutionException, InterruptedException {
        System.out.println("main");
        exeCached.execute(new RunnableTask());
        Future<String> future = exeCached.submit(new CallableTask());
        System.out.println(future.get().toString());
        System.out.println("main");
    }
}
