package interviewbit.stringss;

import static java.lang.System.out;

/**
 * Created by mayan on 18/8/18.
 */
public class ReverseString  {
    public static void main(String[] args){
        //String s = "the sky is blue";
        String s = "fwbpudnbrozzifml osdt ulc jsx t";
        out.println(new ReverseString().reverseWords(s));
    }
    public String reverseWords(String a) {
        String[] arr = a.split(" ");
        StringBuilder sb = new StringBuilder(a.length());
        for(int i = arr.length-1 ; i >=0 ;i--){
            if(arr[i].length() ==1 && arr[i] != " "){
                continue;
            }
            sb.append(arr[i]);
            if(arr[i].length()>1 && i>0){
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}
