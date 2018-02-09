package futures;

/**
 * Created by mayan on 19/11/17.
 * Functional interface to compute big logic
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
