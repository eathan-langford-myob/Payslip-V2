import IO.IConsoleInput;
import IO.IConsoleOutput;
import Payslip.Payslip;
import User.DetailParser;
import User.User;
import Utilities.Orchestrator;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    private static final ResourceBundle outputMessages = ResourceBundle.getBundle("OutputMessages", new Locale("en_US"));
    private static final IConsoleInput input = new IConsoleInput();
    private static final IConsoleOutput output = new IConsoleOutput();
    private static final String[] questions = new String[]{"firstName","lastName","salary","superRate","startDate","endDate"};

    public static void main(String[] args) {
            Orchestrator orchestrator = new Orchestrator(input, output, outputMessages, questions);
    }
}
