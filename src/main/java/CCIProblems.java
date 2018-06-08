import java.util.HashSet;

/**
 * Created by mayan on 8/4/18.
 */
public class CCIProblems {

    private String testString = "thisis";

    public static void main(String[] args){
        HashSet<String> dict = new HashSet<>();
        dict.add("this");
        dict.add("is");
        System.out.println("start");
        CCIProblems cciProblems = new CCIProblems();
        System.out.println(cciProblems.bestSplit(dict,"ABthisisth"));
    }
    private String bestSplit(HashSet<String> dict,String sentence){
        ParseResult result = split(dict,sentence,0);
        return result == null ? null : result.parsed;
    }
    private ParseResult split(HashSet<String> dictionary,String sentence,int start){
        //System.out.println(start);
        //Base case.
        if(start >= sentence.length()){
            return new ParseResult(0,"");
        }
        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing  = null;
        String partial = "";
        int index = start;
        while(index < sentence.length()){
            char c = sentence.charAt(index);
            partial += c;
            System.out.println(partial);
            int invalid = dictionary.contains(partial) ? 0 : partial.length();
            if(invalid < bestInvalid){
                ParseResult result = split(dictionary,sentence,index + 1);
                if(invalid + result.invalid < bestInvalid){
                    bestInvalid = invalid + result.invalid;
                    bestParsing = partial + " " + result.parsed;
                    if(bestInvalid == 0) break;
                }
            }
            index++;
        }
        return new ParseResult(bestInvalid,bestParsing);
    }
}
