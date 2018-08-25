package rx.updatedversion;

import io.reactivex.Observable;
import rx.DataGenerator;

/**
 * Created by mayan on 30/7/18.
 */
public class MyPublisher {
    Observable<Integer> observable = Observable.fromIterable(DataGenerator.generateFibonacci());

    public MyPublisher() throws InterruptedException {

    }
}
