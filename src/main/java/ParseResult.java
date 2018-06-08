/**
 * Created by mayan on 8/4/18.
 */
public class ParseResult {
    public int invalid = Integer.MAX_VALUE;
    public String parsed = "";
    public ParseResult(int inv,String s){
        this.invalid = inv;
        this.parsed = s;
    }
}
