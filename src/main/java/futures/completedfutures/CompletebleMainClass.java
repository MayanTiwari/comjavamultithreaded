package futures.completedfutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.System.out;

/**
 * Created by mayan on 1/8/18.
 */
public class CompletebleMainClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello ");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful World ");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World ");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1,future2,future3);
        if(combinedFuture.isDone()){
            out.println("is done");

        }

       /* String original = "Message";
        CompletableFuture cf1 = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> delayedUpperCase(s));
        CompletableFuture cf2 = cf1.applyToEither(
                CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
                s -> s + " from applyToEither");
        
        assertTrue(cf2.join().endsWith(" from applyToEither"));*/



    }

/*    private static <U> U delayedUpperCase(String s) {
    }*/
}
