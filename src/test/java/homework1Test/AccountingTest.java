package homework1Test;

import homework1.Accounting;
import homework1.HoursException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountingTest {
    private Accounting accounting;

    @Before
    public void setup(){
        accounting = new Accounting(20, 120, 120,
                5, 10);
    }

    @Test
    public void itSalaryCalculation(){
        int actual = accounting.salaryCalculation();
        int expected = 3400 - accounting.getFine();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = HoursException.class)
    public void itSalaryCalculationWithHoursException(){
        accounting.setHoursWorked(121);

        int actual = accounting.salaryCalculation();
    }

    @Test
    public void itGetFine(){
        accounting = new Accounting(20, 100, 120,
                5, 10);

        int actual = accounting.getFine();
        int expected = 150;

        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown(){
        accounting = null;
    }
}
