package interviewbit.stringss;
import static java.lang.System.out;

/**
 * Created by mayan on 19/8/18.
 */
public class StrStr {
    public static void main(String[] args){
        out.println(new StrStr().strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba",
                "babaaa"));
    }
    public int strStr(final String A, final String B) {
        int result= 0;
        int[] lps = computeTemporaryArray(B.toCharArray());
        int i =0;
        int j=0;
        while (i < A.length() && j < B.length()){
            if(A.charAt(i) == B.charAt(j)){
                i++;j++;
            }else{
                if(j !=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == B.length()){
            return j-1;
        }else{
            return -1;
        }
    }

    static int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

}
