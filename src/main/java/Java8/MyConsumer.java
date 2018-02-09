package Java8;

import java.util.function.Consumer;

/**
 * Created by mayan on 22/1/18.
 */
public interface MyConsumer<T> extends Consumer<T> {

    default Consumer<T> duplicate(Consumer<T> c){
        return c;
    }

}
