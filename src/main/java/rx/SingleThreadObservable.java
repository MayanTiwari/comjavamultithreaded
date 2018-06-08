package rx;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;


import static java.lang.System.out;

/**
 * Created by mayan on 4/2/18.
 */
public class SingleThreadObservable {
    public static void main(String[] args) throws InterruptedException {
        Object waitMonitor = new Object();
        synchronized (waitMonitor){
            out.println("Start");
            printCurrentThreadName();
            Observable<Integer> integerObservable = Observable.fromIterable(DataGenerator.generateFibonacci());
            integerObservable
                    //.subscribeOn(Schedulers.computation())
                    .observeOn(Schedulers.io())
                    .subscribe(
                            (i) -> {
                                out.println("onNext thread ");
                                printCurrentThreadName();
                                out.println(i);
                                printCurrentThreadName();
                            },
                            //on error
                            (t) -> {
                                t.printStackTrace();
                            },
                            () -> {
                                out.println("onCompleted");
                                printCurrentThreadName();
                                synchronized (waitMonitor){
                                    waitMonitor.notify();
                                }
                            }
                    );
            ThreadUtils.wait(waitMonitor);
        }

        //System.exit(0);
        //Thread.sleep(5000);
    }

    public static void printCurrentThreadName() {
        out.println(Thread.currentThread().getName());
    }
}
