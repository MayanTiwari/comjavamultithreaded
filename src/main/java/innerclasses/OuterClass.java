package innerclasses;

/**
 * Created by mayan on 11/8/18.
 */
public class OuterClass {
    private int factoryID = 123;

    public static class Wheel {
        public Wheel() {
            //System.out.println("Wheel factory ID: " + factoryID);
            System.out.println("Wheel factory ID: ");
        }
    }
    public class Body{
        public Body(){
            System.out.println("Body  factory ID: " + factoryID);
        }
    }

    public OuterClass() {
        System.out.println("Car Parts object created!");
    }
    public static void main(String[] args){
        OuterClass outerClass = new OuterClass();
        OuterClass.Wheel wheel = new Wheel();
        OuterClass.Body body = outerClass.new Body();

    }
}
