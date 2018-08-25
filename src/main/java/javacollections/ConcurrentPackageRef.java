package javacollections;

import com.sun.org.apache.xerces.internal.util.SymbolTable;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by mayan on 27/6/18.
 */
public class ConcurrentPackageRef {
    public static void main(String[] args){
       /* CopyOnWriteArrayList<String> strings1 = new CopyOnWriteArrayList<>();
        BlockingDeque<String> stringBlockingDeque = new LinkedBlockingDeque<>();
        Set<Integer> integerSet = new TreeSet<>();
        TreeMap<Integer,Integer> integerIntegerTreeMap = new TreeMap<>();*/
       TreeSet<String> strings = new TreeSet<>();
      // strings.add(null);
       strings.add("test");
       System.out.println(strings);
    }

}
