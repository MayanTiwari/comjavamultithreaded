package Java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Created by mayan on 26/1/18.
 */
public class CollectorExample {

    public static void main(String[] args) throws IOException {
        List<Person> persons = new ArrayList<>();

       // try{
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            CollectorExample.class.getResourceAsStream("persons.txt")));

            Stream<String> stream = reader.lines();
            String ss = reader.readLine();
            out.println(ss);

            stream.forEach(s -> out.println(s));
      //  }
       // catch (Exception ex){
       //     out.println(ex.getMessage());
       // }
    }
}
