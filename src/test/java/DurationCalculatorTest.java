import com.duration.calculator.DurationCalculator;
import com.duration.calculator.Impl.DurationCalculatorImpl;
import com.duration.calculator.Month;
import junit.framework.JUnit4TestAdapter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class DurationCalculatorTest {
    private DurationCalculator calculator = null;

    @Before
    public void setUp(){
        calculator = new DurationCalculatorImpl();
    }

    @Test
    public void testValidateInputWithValidInput(){
        String dateFrom = "10/10/2011";
        String dateTo = "12/10/2888";
        boolean val = calculator.validateInput(dateFrom, dateTo);
        Assert.assertTrue(val);
    }

    @Test
    public void testValidateInputWithInValidInput(){
        String dateFrom = "10/10/1901";
        String dateTo = "12/10/2888";
        boolean val = calculator.validateInput(dateFrom, dateTo);
        Assert.assertTrue(val);
    }

    @Test
    public void testMonthValid(){
        Assert.assertEquals(Month.valueOf(03).getValue(),30);
    }

    @Test
    public void testMonthInValid(){
        Assert.assertNotEquals(Month.valueOf(01).getValue(),30);
    }

    @Test
    public void testDaysInMonth(){
       Assert.assertEquals(1096,calculator.calculateDaysElapsed(2000,2003,01,01,10,10));
    }

    @Test
    public void testDaysInMonthInValid(){
        Assert.assertNotEquals(61,calculator.calculateDaysElapsed(2000,2003,02,06,10,10));
    }

    @Test
    public void testVerifyDate(){
        String dateFrom = "10/10/2011";
        String dateTo = "12/10/2012";
        int val = calculator.calculateDays(dateFrom, dateTo);
        Assert.assertEquals(val,730);
    }
    @After
    public void cleanUp(){
        calculator = null;
    }
}
