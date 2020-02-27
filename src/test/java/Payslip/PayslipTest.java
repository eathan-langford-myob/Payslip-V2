package Payslip;

import User.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PayslipTest {
    private Payslip examplePayslip;

    @Before
    public void setUp() {
        examplePayslip = new Payslip("Eathan Langford", "March 1 - March 30", 65000, 15000, 50000, 506);
    }

    @Test
    public void shouldCreatePayslipWithName_WhenConstructed() {
        String expected = "Eathan Langford";

        Assert.assertEquals(examplePayslip.getName(), expected);
    }

    @Test
    public void shouldCreatePayslipWithPayPeriod_WhenConstructed() {
        String expected = "March 1 - March 30";

        Assert.assertEquals(examplePayslip.getPayPeriod(), expected);
    }
    @Test
    public void shouldCreatePayslipWithGrossIncome_WhenConstructed() {
        int expected = 65000;

        Assert.assertEquals(examplePayslip.getGrossIncome(), expected);
    }
    @Test
    public void shouldCreatePayslipWithIncomeTax_WhenConstructed() {
        int expected = 15000;

        Assert.assertEquals(examplePayslip.getIncomeTax(), expected);
    }
    @Test
    public void shouldCreatePayslipWithNetIncome_WhenConstructed() {
        int expected = 50000;

        Assert.assertEquals(examplePayslip.getNetIncome(), expected);
    }
    @Test
    public void shouldCreatePayslipWithSuper_WhenConstructed() {
        int expected = 506;

        Assert.assertEquals(examplePayslip.getPaidSuper(), expected);
    }

   }