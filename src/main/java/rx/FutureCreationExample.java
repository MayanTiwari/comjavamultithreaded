package rx;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import static java.lang.System.out;

/**
 * Created by mayan on 2/2/18.
 */
public class FutureCreationExample {

    public static void main(String[] args){
        out.println("Start");
        FutureTask<List<Integer>> futureTask = new FutureTask<List<Integer>>(() -> {
            return DataGenerator.generateFibonacci();
        });

        Observable<List<Integer>> futureObservable = Observable.fromFuture(futureTask);

        Schedulers.computation().scheduleDirect(() ->{
            futureTask.run();
        });

        futureObservable.subscribe((list) ->{
            out.println("subscribe event");
            list.forEach(out::println);
        });

        out.println("End");
    }
}
