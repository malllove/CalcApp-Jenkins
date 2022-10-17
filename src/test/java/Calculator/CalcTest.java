package Calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class CalcTest {
    int x,y;
    Calc calc = new Calc();
    @Before
    public void setUp(){
       x = 15;
       y = 5;
    }

    @Test
    public void testSummation() {
        int result = x+y;
        Assert.assertEquals(result,calc.summation(x,y));
    }

    @Test
    public void testMultiplication() {
        int result = x*y;
        Assert.assertEquals(result,calc.multiplication(x,y));
    }

    @Test
    public void testSubtraction() {
        int result = x-y;
        Assert.assertEquals(result,calc.subtraction(x,y));
    }

    @Test
    public void testDivision() {
        int result = x/y;
        Assert.assertEquals(result,calc.division(x,y));
    }
}
