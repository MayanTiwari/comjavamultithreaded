/**
 * Created by mayan on 22/10/17.
 */
public class Greeter extends Thread {
    private String country;

    public Greeter(String country) {
        super(country + "thread");
        this.country = country;
    }


    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        System.out.println("hello" + country + "ThreadID=" + id);

    }
}
