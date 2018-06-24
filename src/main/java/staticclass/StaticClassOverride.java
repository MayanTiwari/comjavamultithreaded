package staticclass;

/**
 * Created by mayan on 24/6/18.
 */
public class StaticClassOverride {
    public static void main(String[] args){
        Derived derived = new Derived();
        derived.method();
        Base base = new Derived();
        base.method();

    }
}
