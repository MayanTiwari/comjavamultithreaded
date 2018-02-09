import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.*;

/**
 * Created by mayan on 29/10/17.
 */

public class BitwiseTests {
    private BitWise testClass;

    @Before
    public void setUp() {
        this.testClass = new BitWise();
    }

    @Test
    public void isInitialized() {
        Assert.assertNotNull(this.testClass);
    }

    @Test
    public void BitWiseOrTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void leftShift() {
        Assert.assertEquals("10", BitWise.leftShift(5));
    }

    @Test
    public void Or() {
        out.println(Integer.toBinaryString(60));
        out.println(Integer.toBinaryString(13));
        Assert.assertEquals("111101", BitWise.bitWiseOr(60, 13));
    }

    @Test
    public void And() {
        out.println(Integer.toBinaryString(60));
        out.println(Integer.toBinaryString(13));
        Assert.assertEquals("1100", BitWise.bitWiseAnd(60, 13));
    }

    @Test
    public void powerOfTwo() {
        Assert.assertTrue(BitWise.isPowerOfTwo(8));
    }

    @Test
    public void powerOfTwoConstTime() {
        Assert.assertTrue(BitWise.isPowerOfTwoConstTime(8));
    }
    @Test
    public void getIthBit(){
        out.println(Integer.toBinaryString(60));
        Assert.assertEquals("0",BitWise.getIthBit(60,6));
        Assert.assertEquals("1",BitWise.getIthBit(60,2));
    }
    @Test
    public void updateIthBit(){
        out.println(Integer.toBinaryString(13));
        Assert.assertEquals("1111",BitWise.updateIthBit(13,1));
    }

    @Test
    public void updateIthBitSecond(){
        out.println(Integer.toBinaryString(60));
        Assert.assertEquals("111110",BitWise.updateIthBit(60,1));
    }
    @Test
    public void clearBit(){
        out.println(Integer.toBinaryString(60));
        Assert.assertEquals("110100",BitWise.clearBit(60,3));
    }
    @Test
    public void clearBitMSB(){
        Assert.assertEquals("",BitWise.clearFromMSB(60,2));
    }
}
