package interviewbit.stringss;

import java.util.HashMap;
import java.util.HashSet;

import static java.lang.System.out;

/**
 * Created by mayan on 19/8/18.
 */
public class RomanToInt {
    public static void main(String[] args){
        out.println(new RomanToInt().romanToInt("XIV"));
    }
    public int romanToInt(String A) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('I',1);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;
        for(int i =0 ; i<A.length();i++){
           if(i < A.length()-1){
               if(map.get(A.charAt(i)) < map.get(A.charAt(i+1))){
                   result = result -map.get(A.charAt(i));
               }else{
                   result = result + map.get(A.charAt(i));
               }
           }else{
               result = result + map.get(A.charAt(i));
           }
        }
        return result;
    }
}
