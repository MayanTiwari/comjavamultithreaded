package rx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayan on 2/2/18.
 */
public class DataGenerator {
    public static List<Integer> generateFibonacci() throws InterruptedException {
       // Thread.currentThread().sleep(5000);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(13);

        return list;
    }
}
