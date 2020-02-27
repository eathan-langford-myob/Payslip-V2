package Payslip;

import User.User;

import java.util.Objects;

public class Payslip {
    private String name;
    private  String payPeriod;
    private  int grossIncome;
    private  int incomeTax;
    private  int netIncome;
    private  int paidSuper;

    public Payslip() {
        this("", "", 0,0,0,0);
    }

    public Payslip(String name, String payPeriod, int grossIncome, int incomeTax, int netIncome, int paidSuper) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.paidSuper = paidSuper;
    }

    public Payslip generatePayslip(User user) {
        return new Payslip(user.getFirstName()+user.getLastName(), user.getEndDate()+user.getStartDate(), user.getSalary(), 0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public int getGrossIncome() {
        return grossIncome;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public int getPaidSuper() {
        return paidSuper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payslip payslip = (Payslip) o;
        return getGrossIncome() == payslip.getGrossIncome() &&
                getIncomeTax() == payslip.getIncomeTax() &&
                getNetIncome() == payslip.getNetIncome() &&
                getPaidSuper() == payslip.getPaidSuper() &&
                getName().equals(payslip.getName()) &&
                getPayPeriod().equals(payslip.getPayPeriod());
    }

    public class Calculations {


    }
}
