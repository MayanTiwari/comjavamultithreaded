import jdk.nashorn.internal.runtime.ECMAException;

import static java.lang.System.out;

/**
 * Created by mayan on 24/6/18.
 */
public class JavaExceptions {
    public static void main(String[] args)  {
        out.println("start");
        JavaExceptions javaExceptions = new JavaExceptions();
        try{
            javaExceptions.method();
        }catch (Exception ex){
            out.println("catch main");
        }finally {
            out.println("finally main");
        }

    }
    void method() throws Exception {
        out.println("in method");
        try{

            throw new Exception();
        }catch (Exception ex){
            out.println("method catch");
        }finally {
            out.println("method finally");
            System.exit(0);
        }
        out.println("method end");
    }
}
