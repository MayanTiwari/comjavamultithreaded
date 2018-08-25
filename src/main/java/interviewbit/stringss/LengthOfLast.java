package interviewbit.stringss;

import static java.lang.System.out;

/**
 * Created by mayan on 18/8/18.
 */
public class LengthOfLast {
    public static void main(String[] args){
        String s = "Hello world  ";

        out.println(new LengthOfLast().lengthOfLastWord(s));
    }
    public int lengthOfLastWord(final String A) {
        if(A.isEmpty()) return 0;
        int count = 0 ;

        for(int i = A.length()-1;i >=0; i--){
            if(A.charAt(i) == ' ' && count ==0){
                continue;
            }else if(A.charAt(i) == ' '){
                break;
            }else{
                count++;
            }

        }
        return count;
    }
}
