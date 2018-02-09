package rx;

import java.util.function.BiFunction;

import static java.lang.System.out;

/**
 * Created by mayan on 27/1/18.
 */
public class FirstClassFunctions {

    public static void main(String[] args){

        BiFunction<String,String,String> concatFunction = (s,t) -> {
            return s + t;
        };
        out.println(concatFunction.apply("Hello","World"));
        concatFunction = FirstClassFunctions::concatStrings;
        out.println(concatFunction.apply("H","W"));

    }
    private static String concatStrings(String s1,String s2){
        return s1+s2;
    }
}
