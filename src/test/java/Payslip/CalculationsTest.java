package Payslip;

import User.User;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CalculationsTest {
    private String name;
    private String payPeriod;
    private int grossIncome;
    private int incomeTax;
    private int netIncome;
    private int paidSuper;
    private User exampleUser;
    private Payslip payslip;


    @Before
    public void setUp() throws Exception {
        exampleUser = new User("Eathan", "Langford", "60050", "9", "March 1", "March 30");
        payslip = new Payslip();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldReturnCombinedFirstAndLastName_WhenGeneratingPayslip() throws IOException, ParseException {
        String actual = payslip.generatePayslip(exampleUser).getName();
        String expected = "Eathan Langford";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCombinedPayPeriod_WhenGeneratingPayslip() throws IOException, ParseException {
        String actual = payslip.generatePayslip(exampleUser).getPayPeriod();
        String expected = "March 1 - March 30";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnGrossIncome_WhenGeneratingPayslip() throws IOException, ParseException {
        long actual = payslip.generatePayslip(exampleUser).getGrossIncome();
        long expected = 5004;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCalculatedIncomeTax_WhenGeneratingPayslip() throws IOException, ParseException {
        long actual = payslip.generatePayslip(exampleUser).getIncomeTax();
        long expected = 922;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCalculatedNetIncome_WhenGeneratingPayslip() throws IOException, ParseException {
        long actual = payslip.generatePayslip(exampleUser).getNetIncome();
        long expected = 4082;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCalculatedSuper_WhenGeneratingPayslip() throws IOException, ParseException {
        long actual = payslip.generatePayslip(exampleUser).getPaidSuper();
        long expected = 450;

        Assert.assertEquals(expected, actual);
    }
}