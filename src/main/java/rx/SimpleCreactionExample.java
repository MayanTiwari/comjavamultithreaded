package rx;

import io.reactivex.Observable;


/**
 * Created by mayan on 2/2/18.
 */
public class SimpleCreactionExample {

    public static void main(String[] args){
        Observable<Integer> integerObservable = null;
        System.out.println("Observable creation");
        integerObservable = Observable.fromArray(Integer.valueOf(42),Integer.valueOf(43));
        integerObservable.subscribe( (i) -> {
           System.out.println(i);
        });

        }
}

