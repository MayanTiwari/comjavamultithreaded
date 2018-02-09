package Java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;


import static java.lang.System.out;

/**
 * Created by mayan on 27/1/18.
 */
public class DateAPIs {
    public static void main(String[] args){
        out.println("From main");

        //Date is mutable
        //Date date = new Date();
       // out.println(date);

        Instant instant = Instant.now();
        out.println(instant.getEpochSecond());

        LocalDate localDate = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(1564, Month.APRIL,23);


    }
}
