package Utilities;

import IO.IConsoleInput;
import IO.IConsoleOutput;
import IO.IInput;
import IO.IOutput;
import Payslip.Payslip;
import User.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import User.DetailParser;

public class Orchestrator {
    private final String[] questions;
    IInput input;
    IOutput output;
    ResourceBundle outputMessages;

    public Orchestrator(IInput input, IOutput output, ResourceBundle outputMessages, String[] questions) {
        this.input = input;
        this.output = output;
        this.outputMessages = outputMessages;
        this.questions = questions;

    }

    private void displayMessage(String questionReference) {
        output.displayOutput(outputMessages.getString(questionReference));
    }

    private String getAnswer() {
        return input.getInput();
    }

    private boolean validateAnswer(String question, String answer) {
        switch (question) {
            case ("firstName"):
            case ("lastName"):
                return true;
            case ("salary"):
            case ("superRate"):
                return InputValidator.isValidDigit(answer);
            case ("startDate"):
            case ("endDate"):
                return InputValidator.isValidDateFormat(answer);
            default:
                return false;
        }
    }


    private HashMap<String, String> getValidDetails() {
        HashMap<String, String> userDetails = new HashMap<>();
        displayMessage("welcome");
        for (String question : questions) {
            boolean validAnswer = false;
            while (!validAnswer) {
                displayMessage(question);
                String answer = getAnswer();
                validAnswer = validateAnswer(question, answer);
                userDetails.put(question, answer);
                displayMessage(validAnswer ? "valid" : "invalid");
            }
        }
        return userDetails;
    }

    public void run() {
        Payslip userPayslip = new Payslip();
        while (true) {
            HashMap<String, String> validUserDetails = getValidDetails();
            User validUser = DetailParser.parseDetailsToUser(validUserDetails);
            try {
                output.displayOutput(userPayslip.generatePayslip(validUser).print());
                break;
            } catch (ParseException | IOException e) {
                output.displayOutput("Error in creating payslip. Please try again.");
            }
        }
    }
}
