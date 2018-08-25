package factory;

/**
 * Created by mayan on 27/6/18.
 */
public class FactoryClass {
    public static Shape getInstance(String name){
        Shape shape = null;
        if(name.equals("Circle"))
            shape = new  Circle();
        return shape;

    }
}
