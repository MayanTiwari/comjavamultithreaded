package futures;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.lang.System.out;

/**
 * Created by mayan on 22/6/18.
 */
public class JavaForkJoin {
    public static void main(String[] args){
        JavaForkJoin javaForkJoin = new JavaForkJoin();
        try {
            javaForkJoin.testFun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void testFun() throws Exception {
      //  ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
       // CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("ABCDEGFASDFAHASDGASDF");
       // forkJoinPool.execute(customRecursiveAction);
        //RecursiveAction
       // Boolean aBoolean = new Boolean("truE");
        t1();
        out.println("end");
    }
    public void t1() throws Exception{
        try{
            throw new Exception();
        }catch (Exception ex){
            out.println("catch");
            throw new Exception();
        }finally {
            out.println("finally");
        }

    }
}
