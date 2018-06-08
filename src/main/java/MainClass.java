import java.util.*;
import java.util.stream.Stream;

/**
 * Created by mayan on 11/5/18.
 */
public class MainClass {
    public static void main(String[] args){
        HashMap<String,String> stringStringHassMap;

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("C");
        strings.add("D");

        /*for(String s : strings){
            if(s.equals("A")) strings.remove(s);
        }*/

        Iterator<String> iterator = strings.iterator();
        ListIterator<String> stringListIterator = strings.listIterator();

        while (iterator.hasNext()){
            String temp = iterator.next();
            if(temp.equals("A")) iterator.remove();
        }
        System.out.println(strings.size());
    }
}
