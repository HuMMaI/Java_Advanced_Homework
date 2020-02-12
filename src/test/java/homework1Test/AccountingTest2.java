package homework1Test;

import homework1.Accounting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountingTest2 {
    private Accounting accounting;

    @Before
    public void setup(){
        accounting = new Accounting(20, 120, 120,
                5, 10);
    }

    @Test
    public void itHospitalCalculation(){
        int actual = accounting.hospitalCalculation();
        int expected = 600;

        Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown(){
        accounting = null;
    }
}
