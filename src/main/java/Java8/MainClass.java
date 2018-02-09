package Java8;

import javax.print.DocFlavor;
import java.io.*;
import java.io.FileFilter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import  static  java.lang.System.out;

/**
 * Created by mayan on 20/1/18.
 */
public class MainClass {
    public static void main(String[] args){
        java.io.FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };
        FileFilter fileFilter1 = (File file) -> file.getName().endsWith(".java");

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return 0;
            }
        };
        Comparator<String> comparator1 = (s1,s2) -> 0;
        //Wrong
        //InnerInterface innerInterface  = (String s) -> s.endsWith(".java");
        //FuncInterface lanbda = (InnerInterface innerLambda) -> innerInterface.accept("");

        Consumer<String> c = s -> out.println(s);
        Consumer<String> cc = out::println;

        List<String> strings = Arrays.asList("one","two","three","four");
        Consumer<String> c1 = out::println;
        strings.forEach(c1);




    }
}
