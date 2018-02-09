package futures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by mayan on 13/12/17.
 */
public class SingleThreadPageRenderer {

    public void renderPage(Object source) throws InterruptedException {
        renderText();
        List<ImageData> imageData = new ArrayList<>();
        for (ImageInfo imageInfo: scanForImageInfo(source)){
            imageData.add(imageInfo.downloadImage());
        }
        for (ImageData data: imageData){
            renderImage(data);
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
