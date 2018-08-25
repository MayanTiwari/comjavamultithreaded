package rx.updatedversion;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 30/7/18.
 */
public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> symbols){
        out.println("Created..");
        return Observable.create(emitter -> emitPrice(emitter,symbols));
    }

    private static void emitPrice(ObservableEmitter<StockInfo> emitter,List<String> symbols) {
        out.println("Ready to emit..");
        int count = 0;
        while(count < 5){
            symbols.stream()
                    .map(StockInfo:: fetch)
                    .forEach(emitter::onNext);
            sleep(1000);
            if(count > 2) emitter.onError(new RuntimeException());
            count++;
        }
        emitter.onComplete();
        emitter.onNext(new StockInfo("Bla",0));
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
