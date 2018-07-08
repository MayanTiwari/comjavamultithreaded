package factory;

/**
 * Created by mayan on 27/6/18.
 */
public class FactoryTestClass {
    public static void main(String[] args){
        FactoryClass factoryClass = new FactoryClass();
        Shape shape = factoryClass.getInstance("Circle");
    }
}
