package futures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mayan on 14/1/18.
 */
public class RendererCompService {
    private final ExecutorService executorService;

    public RendererCompService(ExecutorService executorService) {
        this.executorService = executorService;
    }
    void renderPage() throws InterruptedException {
        final List<ImageInfo> info = new ArrayList<>();
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executorService);
        for(ImageInfo d : info ){
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return d.downloadImage();
                }
            });
        }
        //renderText();
        try {
            for(int t=0,n = info.size();t < n ; t++){
                Future<ImageData> f = completionService.take();
            }
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
