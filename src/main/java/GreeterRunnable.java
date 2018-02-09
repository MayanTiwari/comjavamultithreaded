/**
 * Created by mayan on 22/10/17.
 */
public class GreeterRunnable implements Runnable {
    String country ;
    public GreeterRunnable(String country) {
        this.country = country;
    }

    public void run() {
        long id = Thread.currentThread().getId();
        System.out.println(country + "ThreadID:" + id);
    }
}
