package futures.notification;

import java.util.concurrent.*;

import static java.lang.System.out;

/**
 * Created by mayan on 3/8/18.
 */
public class MainTestClass {
    static class Notifyed implements CallBack{

        @Override
        public void notified() {
            out.println("Notified Done");
        }
    }
    static class Call implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "from callable";
        }
    }
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Call call = new Call();
        Notifyed notifyed = new Notifyed();

        FutureTask<String> taslk = new CustomTask(call,() -> {
            out.println("Notified");
        });

        executorService.submit(taslk);

    }
}
