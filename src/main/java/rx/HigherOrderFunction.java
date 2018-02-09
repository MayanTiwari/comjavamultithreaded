package rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.function.Function;
import java.util.function.Supplier;


import static java.lang.System.out;

/**
 * Created by mayan on 27/1/18.
 */
public class HigherOrderFunction {
    public static void main(String[] args){

        Supplier<String> stringSupplier = createCombineAndTransform("Hello","world",(s) -> {
            return s.toUpperCase();
        });
        out.println(stringSupplier.get());

    }
    public static Supplier<String> createCombineAndTransform(final String a, final String b,
                                                             final Function<String,String> transformer){

        return () ->
        {
            String aa = a;
            String bb =b;

            if(transformer !=null){
                aa = transformer.apply(a);
                bb = transformer.apply(b);
            }
            return aa + bb;
        };
    }
}
