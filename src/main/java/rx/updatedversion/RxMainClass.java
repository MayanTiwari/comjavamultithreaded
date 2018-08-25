package rx.updatedversion;
import io.reactivex.*;
import io.reactivex.Observable;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mayan on 30/7/18.
 */
public class RxMainClass {

    public static void main(String[] args){
        List<String> symbols  = Arrays.asList("GOOG","AMZN","ITC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        feed
                .map(sI -> new StockInfo(sI.ticker,sI.value*2))
                .subscribe(stockInfo -> out.println(stockInfo),
                            (error) -> out.println(error.getCause()),
                            () -> out.println("Completed"));
        out.println("Got observable");
    }
}
