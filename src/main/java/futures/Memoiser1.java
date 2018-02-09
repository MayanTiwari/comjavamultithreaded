package futures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayan on 19/11/17.
 */
public class Memoiser1<A,V> implements Computable<A,V>{

    private final Computable<A,V> c;
    private final Map<A,V> cache = new HashMap<A, V>();

    public Memoiser1(Computable<A, V> c) {
        this.c = c;
    }

    //Scalability problem this is conservative approach
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result ==null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
