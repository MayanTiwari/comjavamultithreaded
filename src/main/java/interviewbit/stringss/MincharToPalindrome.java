package interviewbit.stringss;

import static java.lang.System.out;

/**
 * Created by mayan on 19/8/18.
 */
public class MincharToPalindrome {
    public static void main(String[] args){
        //out.println(new MincharToPalindrome().solve("CABAD"));
        //int a = new MincharToPalindrome().solve("ABC");
        out.println(computeTemporaryArray("abcdabca".toCharArray()));
       // out.println(a);
    }
   /* public int solve(String A) {
        boolean isEven = A.length() %   2 == 0 ? true: false;
        int i,j;
        int count =0;
        if(isEven){
            i = A.length()/2-1;
            j = A.length()/2;
        }else{
            i = A.length()/2;
            j = A.length()/2;
        }
        while(i > 0 && j < A.length()-1){

        }

        return 0;
    }*/
   public int solve(String A) {
        if(A.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        for(int i =0;i < A.length();i++){
            sb.append(A.charAt(i));
        }
        for(int i = A.length()-1;i>=0;i--){
            if(sb.charAt(A.length()-1) != A.charAt(i)){
                sb.append(A.charAt(i));
            }
        }
        int[] cValue = computeTemporaryArray(sb.toString().toCharArray());
        int c = cValue[cValue.length-1];
        return A.length()-c;
   }
    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
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
