package futures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by mayan on 14/1/18.
 */
public class FutureRenderer {
    private final ExecutorService executorService = Executors.newCachedThreadPool() ;

    private List<ImageData> imageInfos = new ArrayList<>();
    void renderPage() throws Exception {
        renderText();
        List<ImageData> imageData = new ArrayList<>();
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> result = new ArrayList<>();
                for(ImageData imageInfo : imageInfos){
                    result.add(imageInfo);
                }
                return result;
            }
        };
        Future<List<ImageData>> future = executorService.submit(task);
        try {
            List<ImageData> dataImages = future.get();
            for(ImageData data : dataImages ){
                //User the result
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e){
            throw new Exception();
        }
    }
    private List<ImageInfo> scanForImageInfo(Object source) {
        return new ArrayList<>();
    }

    private void renderText() throws InterruptedException {
        System.out.println("Render text");
        SECONDS.sleep(1);
        //fast method just to render text
    }
    private void renderImage(ImageData data){

    }
}
