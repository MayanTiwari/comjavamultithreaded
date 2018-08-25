package interviewbit.stringss;

import static java.lang.System.out;

/**
 * Created by mayan on 18/8/18.
 */
public class StringPalindrome {
    public static void main(String[] args){
        out.println(isLetterOrDigit(' '));
        StringPalindrome stringPalindrome = new StringPalindrome();
        //out.println(stringPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        out.println(stringPalindrome.isPalindrome("naayyaan"));
    }
    public int isPalindrome(String A) {
        if(A.isEmpty()) return -1;
        StringBuilder sb = new StringBuilder(A.length());
        //Remove spaces and non alpha values.
        for(char c : A.toCharArray()){
            if(isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int i =0;
        int j= sb.length()-1;
        String s = sb.toString();
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }
    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
}
