package Payslip;

public class PayslipStringParser {

    public static String parsePayslip(Payslip payslip) {
        return "_____________________________________________" + "\n"+
                "| Name: "+payslip.getName()+"\n"+
                "| Pay Period: "+payslip.getPayPeriod()+"\n"+
                "| Gross Income: "+payslip.getGrossIncome()+"\n"+
                "| Income Tax: "+payslip.getIncomeTax()+"\n"+
                "| Net Income: "+payslip.getNetIncome()+"\n"+
                "| Paid Super:  "+payslip.getPaidSuper()+"\n"+
                "_____________________________________________";
    }
}
