package Payslip;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PayslipStringParserTest {


    @Test
    public void parsePayslip() {
        String expected =
                "_____________________________________________" + "\n"+
                "| Name: Eathan Langford"+"\n"+
                "| Pay Period: March 1 - March 30"+"\n"+
                "| Gross Income: 5004"+"\n"+
                "| Income Tax: 922"+"\n"+
                "| Net Income: 4082"+"\n"+
                "| Paid Super:  450"+"\n"+
                "_____________________________________________";

        String actual = PayslipStringParser.parsePayslip(new Payslip("Eathan Langford", "March 1 - March 30", 5004, 922, 4082, 450));

        Assert.assertEquals(expected, actual);
    }
}