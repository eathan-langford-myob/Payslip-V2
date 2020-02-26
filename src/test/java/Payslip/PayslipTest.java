package Payslip;

import User.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PayslipTest {
    private Payslip actual;

    @Before
    public void setUp() {
        actual = new Payslip("Eathan Langford", "March 1-30", 65000, 15000, 50000, 506);
    }

    @Test
    public void shouldCreatePayslipWithName_WhenConstructed() {
        String expected = "Eathan Langford";

        Assert.assertEquals(actual.getName(), expected);
    }

    @Test
    public void shouldCreatePayslipWithPayPeriod_WhenConstructed() {
        String expected = "March 1-30";

        Assert.assertEquals(actual.getPayPeriod(), expected);
    }
    @Test
    public void shouldCreatePayslipWithGrossIncome_WhenConstructed() {
        int expected = 65000;

        Assert.assertEquals(actual.getGrossIncome(), expected);
    }
    @Test
    public void shouldCreatePayslipWithIncomeTax_WhenConstructed() {
        int expected = 15000;

        Assert.assertEquals(actual.getIncomeTax(), expected);
    }
    @Test
    public void shouldCreatePayslipWithNetIncome_WhenConstructed() {
        int expected = 50000;

        Assert.assertEquals(actual.getNetIncome(), expected);
    }
    @Test
    public void shouldCreatePayslipWithSuper_WhenConstructed() {
        int expected = 506;

        Assert.assertEquals(actual.getPaidSuper(), expected);
    }
   }