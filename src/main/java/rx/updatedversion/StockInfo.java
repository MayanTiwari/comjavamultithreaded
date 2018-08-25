package rx.updatedversion;

/**
 * Created by mayan on 30/7/18.
 */
public class StockInfo {

    public String ticker;
    public double value;

    public StockInfo(String ticker, double value) {
        this.ticker = ticker;
        this.value = value;
    }

    public static StockInfo fetch(String s) {
        return  new StockInfo("Y",125);
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "ticker='" + ticker + '\'' +
                ", value=" + value +
                '}';
    }
}
