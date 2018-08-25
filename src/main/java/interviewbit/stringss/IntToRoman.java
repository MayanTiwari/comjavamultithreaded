package interviewbit.stringss;

import java.util.HashMap;

/**
 * Created by mayan on 19/8/18.
 */
public class IntToRoman {
    public static void main(String[] args){

    }
    public String intToRoman(int A) {
        HashMap<Integer,Character> map = new HashMap<>();
        map.put(1,'I');
        map.put(5,'V');
        map.put(1,'I');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        StringBuffer sb = new StringBuffer();
        int factor = 1000;
        while(factor >0){
            int num = A/factor;
        }
        return "";
    }
}
