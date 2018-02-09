package futures;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mayan on 19/11/17.
 */
public class Memoiser2<A,V> implements Computable<A,V> {

    private final Computable<A, V> c;
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();

    public Memoiser2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
