package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Created by mayan on 22/1/18.
 */
public class StreamAndCollectors {
    public static void main(String[] args){

      /*  List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(30);
        p1.setName("AB");

        Person p2 = new Person();
        p2.setAge(20);
        p2.setName("ABC");

        Person p3 = new Person();
        p3.setAge(30);
        p3.setName("ABD");

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        Stream<Person> personStream = personList.stream();
        Consumer<Person> c1 = out::println;
        MyConsumer<Person> c2 = out::println;
        personStream.forEach(c1.andThen(c2));
        personStream.forEach(c2.duplicate(c1));

        Stream<Person> filtered = personStream.filter(person -> person.getAge() > 20);*/

        Stream<String> stream = Stream.of("one","two","three","four");
        Predicate<String> p11 = s -> s.length() > 3;
        stream
                .peek(out::println)
                .filter(p11)
                .findFirst()
               // .forEach(out::println);
                ;



    }
}
