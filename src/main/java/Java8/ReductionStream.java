package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

/**
 * Created by mayan on 26/1/18.
 */
public class ReductionStream {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,10);

        Integer red = list.stream()
                            .reduce(0,Integer::sum);

        //Optional
        Optional<Integer> redMax = list.stream()
                .reduce(Integer::max);

        out.println(redMax.get());

    }
}
