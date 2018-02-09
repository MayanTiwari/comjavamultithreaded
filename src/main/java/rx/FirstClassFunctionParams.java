package rx;

import java.util.function.Function;

import static java.lang.System.out;

/**
 * Created by mayan on 27/1/18.
 */
public class FirstClassFunctionParams {
    public static void main(String[] args) {
        out.println(concatAndTransform("hello", "world", s -> {
            return s.toLowerCase();
        }));
        Function<String,String> transformFunc = s -> {
            return s.toUpperCase();
        };
        out.println(concatAndTransform("Hello","World",transformFunc));
    }
    public static String concatAndTransform(String a, String b, Function<String, String> stringTransform) {
        if (stringTransform != null) {
            a = stringTransform.apply(a);
            b = stringTransform.apply(b);
        }
        return a + b;
    }
}

