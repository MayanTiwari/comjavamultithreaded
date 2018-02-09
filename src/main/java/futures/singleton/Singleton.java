package futures.singleton;


/**
 * Created by mayan on 9/12/17.
 */
public final class Singleton {

    static Object key = new Object();
    private static volatile Singleton instance;

    private void Singleton(){}

    //In case of multi core cpus this is going to be performance hit, since all threads
    //needs to wait for the instance .
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    //Double check locking.
    //This also is having problem . Happens before issue, object may not have
    //fully build before the read .
    //Solution is to make instance volatile
    //Double check locking performance issue.
    public static Singleton doubleCheckLocking(){
        if(instance != null){
            return instance;
        }
        synchronized (key){
            if(instance == null){
                instance = new Singleton();
            }
            return instance;
        }
    }

}
