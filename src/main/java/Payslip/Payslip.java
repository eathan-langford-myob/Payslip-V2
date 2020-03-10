package Payslip;

import Data.ParserJSON;
import User.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Payslip {
    private String name;
    private  String payPeriod;
    private  long grossIncome;
    private  long incomeTax;
    private  long netIncome;
    private  long paidSuper;

    public Payslip() {
        this("", "", 0,0,0,0);
    }

    public Payslip(String name, String payPeriod, long grossIncome, long incomeTax, long netIncome, long paidSuper) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.paidSuper = paidSuper;
    }

    public Payslip generatePayslip(User user) throws IOException, ParseException {
        Calculations taxCalculator = new Calculations(user);
        return new Payslip(taxCalculator.calculateName(), taxCalculator.calculatePayPeriod(), taxCalculator.calculateGrossIncome(), taxCalculator.calculateIncomeTax(), taxCalculator.calculateNetIncome(), taxCalculator.calculatePaidSuper());
    }

    public String getName() {
        return name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public long getGrossIncome() {
        return grossIncome;
    }

    public long getIncomeTax() {
        return incomeTax;
    }

    public long getNetIncome() {
        return netIncome;
    }

    public long getPaidSuper() {
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

    public String print() {
        return "Payslip \n" +
                "name :'" + name + '\'' +
                "\n payPeriod :'" + payPeriod + '\'' +
                "\n grossIncome :" + grossIncome +
                "\n incomeTax :" + incomeTax +
                "\n netIncome :" + netIncome +
                "\n paidSuper :" + paidSuper;
    }

    public class Calculations {
        private User user;
        private JSONObject taxBracket;
        private String calculatedName;
        private String calculatedPayPeriod;
        private long calculatedGrossIncome;
        private long calculatedIncomeTax;
        private long calculatedNetIncome;
        private long calculatedSuper;


        public Calculations(User user) {
            this.user = user;
        }

        private JSONObject calculateTaxBracket() throws IOException, ParseException {
            ParserJSON parser = new ParserJSON(System.getenv("TAX_DATA"));
            JSONArray taxInformation = parser.getParsed();

            for (Object singleTaxBracket : taxInformation) {
                JSONObject parsedTaxBracket = (JSONObject) singleTaxBracket;
                if (parser.isSalaryWithinTaxBracket(user.getSalary(), parsedTaxBracket)) {
                    taxBracket = parsedTaxBracket;
                }
            }
            return taxBracket;
        }

        private String calculateName() {
            calculatedName = String.format("%s %s", user.getFirstName(), user.getLastName());
            return calculatedName;
        }

        private String calculatePayPeriod() {
            calculatedPayPeriod = String.format("%s - %s", user.getStartDate(), user.getEndDate());
            return calculatedPayPeriod;
        }

        private long calculateGrossIncome() {
            calculatedGrossIncome = (int) Math.floor(user.getSalary() / 12);
            return calculatedGrossIncome;
        }

        //    income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922
        private long calculateIncomeTax() throws IOException, ParseException {
            JSONObject taxBracket = calculateTaxBracket();
            long lowerThreshold = (((long) taxBracket.get("lowerThreshold"))-1);
            long initialCharge = ((long) taxBracket.get("initialCharge"));
            double taxRate = ((double) taxBracket.get("perDollar")/100);
            calculatedIncomeTax = Math.round(((initialCharge + (user.getSalary() - lowerThreshold) * taxRate) / 12));
            return calculatedIncomeTax;
        }

        private long calculateNetIncome() {
            calculatedNetIncome = calculatedGrossIncome - calculatedIncomeTax;
            return calculatedNetIncome;
        }

        private long calculatePaidSuper() {
            calculatedSuper = calculatedGrossIncome * user.getSuperRate()/100;
            return Math.round(calculatedSuper);
        }
    }
}
