package Payslip;

import User.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculationsTest {
    private String name;
    private  String payPeriod;
    private  int grossIncome;
    private  int incomeTax;
    private  int netIncome;
    private  int paidSuper;
    private User exampleUser;
    private Payslip payslip;

//    For example, the payment in March for an employee with an annual salary of $60,050 and a super rate of 9% is:
//
//    pay period = Month of March (01 March to 31 March)
//    gross income = 60,050 / 12 = 5,004.16666667 (round down) = 5,004
//    income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922
//    net income = 5,004 - 922 = 4,082
//    super = 5,004 x 9% = 450.36 (round down) = 450

    @Before
    public void setUp() throws Exception {
        exampleUser = new User("Eathan", "Langford", 60050, 9, "March 1", "March 30");
        payslip = new Payslip();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldReturnCombinedFirstAndLastName_WhenGeneratingPayslip() {
        String actual = payslip.generatePayslip(exampleUser).getName();
        String expected = "Eathan Langford";

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void shouldReturnCombinedPayPeriod_WhenGeneratingPayslip() {
        String actual = payslip.generatePayslip(exampleUser).getPayPeriod();
        String expected = "March 1 - March 30";

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void shouldReturnGrossIncome_WhenGeneratingPayslip() {
        int actual = payslip.generatePayslip(exampleUser).getGrossIncome();
        int expected = 5004;

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void shouldReturnCalculatedIncomeTax_WhenGeneratingPayslip() {
        int actual = payslip.generatePayslip(exampleUser).getIncomeTax();
        int expected = 922;

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void shouldReturnCalculatedNetIncome_WhenGeneratingPayslip() {
        int actual = payslip.generatePayslip(exampleUser).getNetIncome();
        int expected = 4082;

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void shouldReturnCalculatedSuper_WhenGeneratingPayslip() {
        int actual = payslip.generatePayslip(exampleUser).getPaidSuper();
        int expected = 450;

        Assert.assertEquals(actual, expected);
    }
}
