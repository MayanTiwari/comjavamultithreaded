package futures;

/**
 * Created by mayan on 13/12/17.
 */
public class ImageInfo {
    public ImageData downloadImage() throws InterruptedException {
        Thread.sleep(3000);
        return new ImageData();
    }
}
