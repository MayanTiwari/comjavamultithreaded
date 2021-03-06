package designs;

import static java.lang.System.out;

/**
 * Created by mayan on 3/6/18.
 */
public class Base62 {

    public static void main(String[] args){
        out.println(BASE62.length);
        out.println(base62(631));
        out.println(base62("AB"));
    }
    /**
     * Base62 characters table sorted to quickly calculate decimal equivalency by compensating.
     */
    static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * Returns the base 62 string of an integer.
     *
     * @return the base 62 string of an integer
     */
    public static String base62(int value) {
        final StringBuilder sb = new StringBuilder(1);
        do {
            sb.insert(0, BASE62[value % 62]);
            value /= 62; // value = value/62;
        } while (value > 0);
        return sb.toString();
    }

    /**
     * Returns the base 62 value of a string.
     *
     * @return the base 62 value of a string.
     */
    public static int base62(String value) {
        int result = 0;
        int power = 1;
        for (int i = value.length() - 1; i >= 0; i--) {
            int digit = value.charAt(i) - 48;
            if (digit > 42) {
                digit -= 13;
            } else if (digit > 9) {
                digit -= 7;
            }
            result += digit * power;
            power *= 62;
        }
        return result;
    }
}
