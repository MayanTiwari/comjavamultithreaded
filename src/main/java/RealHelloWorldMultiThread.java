import futures.GreeterCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import static java.lang.System.out;

/**
 * Created by mayan on 22/10/17.
 */
public class RealHelloWorldMultiThread {

    public static void main(String[] args){
            Runnable r = () ->
            {
                out.println("Hello World");
                out.println(Thread.currentThread().getName());
            };
            Thread t  = new Thread(r);
            t.setName("NewThread");
            t.start();
            out.println("Main Thread");
            t.interrupt();

    }
    public static void runnable(){
        String[] countries = {"France","India","China","USA","Germany"};
        for(String country : countries ){
            //System.out.println(country);
            //new Thread().run();
            //new Greeter(country).run();
            new Thread(new GreeterRunnable(country)).start();
            //new Thread(new GreeterCallable()).start();//I cannot pass callable to thread class.

        }
    }
    public void callable() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new GreeterCallable());
        System.out.println(Thread.currentThread().getId());
        new Thread(futureTask).start();
        if(futureTask.isDone()){
            System.out.println("Is done");
        }else{
            System.out.println("Not done");
        }
       // futureTask.run();
        System.out.println(futureTask.get().toString());
        System.out.println("End");

    }

}
