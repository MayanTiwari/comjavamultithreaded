package futures.singleton;

/**
 * Created by mayan on 3/8/18.
 */
public enum ESingleTon {
    INSTANCE;
    int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
