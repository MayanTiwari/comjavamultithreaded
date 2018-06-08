package rx;

import io.reactivex.Observable;

import static io.reactivex.Observable.fromIterable;

/**
 * Created by mayan on 6/4/18.
 */
public class PredicateExample {
    
 public static void main(String[] args) throws InterruptedException {
     fromIterable(DataGenerator.generateFibonacci())
             .filter((f) -> f > 3)
             .subscribe((num) -> {
                System.out.println(num);
             });
 }
}
