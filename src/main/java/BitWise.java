import static java.lang.System.out;

/**
 * Created by mayan on 25/10/17.
 */
public class BitWise {
    public static void main(String[] args) {
        //Check if the number is power of 2
        //System.out.println(isPowerOfTwoConst(6));
        // System.out.println(Integer.toBinaryString(5));
        //System.out.println(leftShift(5));
    }

    public static String leftShift(int x) {
        return Integer.toBinaryString(x >> 1);
    }

    public static boolean isPowerOfTwo(int number) {
        if (number == 0) {
            return false;
        } else {
            while (number % 2 == 0) number /= 2;
            return (number == 1);
        }
    }

    public static String bitWiseOr(int x, int y) {
        return Integer.toBinaryString(x | y);
    }

    public static String bitWiseAnd(int x, int y) {
        return Integer.toBinaryString(x & y);
    }

    public static boolean isPowerOfTwoConstTime(int x) {

        int t = x & (x - 1);
        //System.out.println(t);
        return (x != 0 && (t == 0));
    }

    public static String getIthBit(int x, int i) {
        int temp = (int) (x & (1 << i)) == 0 ? 0 : 1;
        return Integer.toBinaryString(temp);
    }

    public static boolean countOne(int x) {
        return false;// x & (x -1);
    }

    public static String updateIthBit(int x, int i) {
        int temp = (int) (x | 1 << i);
        return Integer.toBinaryString(x |= (1 << i));
    }

    public static String clearBit(int x, int i) {
        int mask = ~(1 << i);
        return Integer.toBinaryString(x & mask);
    }
    public static String clearFromMSB(int x,int i){
        out.println(Integer.toBinaryString(x));
        int mask = (1 << i);
        out.println(Integer.toBinaryString(mask));
        mask = (1 << i) -1;
        out.println(Integer.toBinaryString(mask));
        return Integer.toBinaryString(x & mask);
    }
}
