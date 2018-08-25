package interviewbit.stringss;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by mayan on 19/8/18.
 */
public class LongestCommonPrefix {
    public static void main(String[] args){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abcd");
        strings.add("abcd");
        strings.add("efgh");
        out.println(new LongestCommonPrefix().longestCommonPrefix(strings));
    }
    public String longestCommonPrefix(ArrayList<String> A) {
        if(A.size() == 0) return "";
        String pref = A.get(0);
        for(int i =1; i < A.size();i++){
            pref = lcp(pref,A.get(i));
        }
        return pref;
    }
    public String lcp(String s1,String s2){
        String small = s1.length() < s2.length() ? s1 : s2;
        String large = s1.length() >= s2.length() ? s1 : s2;
        StringBuilder sb = new StringBuilder(s1.length());
        for(int i =0;i < small.length();i++){
            if(small.charAt(i)!= large.charAt(i)){
                break;
            }
            sb.append(small.charAt(i));
        }
        return sb.toString();
    }
}
