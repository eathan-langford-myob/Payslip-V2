package Utilities;

import IO.MockConsoleInputPayslip_happyPath;
import IO.MockConsoleInputPayslip_sadPath;
import IO.MockOutputCollector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class OrchestratorTest {
    private final ResourceBundle outputMessages = ResourceBundle.getBundle("OutputMessages", new Locale("en_US"));
    private final MockConsoleInputPayslip_happyPath inputHappyPath = new MockConsoleInputPayslip_happyPath();
    private final MockConsoleInputPayslip_sadPath inputSadPath = new MockConsoleInputPayslip_sadPath();
    private MockOutputCollector output = new MockOutputCollector();
    private final String[] questions = new String[]{"firstName", "lastName", "salary", "superRate", "startDate", "endDate"};
    Orchestrator happyOrchestrator;
    Orchestrator sadOrchestrator;

    @Before
    public void setUp() {
        happyOrchestrator = new Orchestrator(inputHappyPath, output, outputMessages, questions);
        sadOrchestrator = new Orchestrator(inputSadPath, output, outputMessages, questions);
    }

    @After
    public void tearDown() {
        happyOrchestrator = null;
        sadOrchestrator = null;
        output = null;
    }

    @Test
    public void shouldReturnValidPayslipWithErrorMessageInPath_WhenGivenSadPath() {
        sadOrchestrator.run();
        ArrayList<String> expected = new ArrayList<>();
        expected.add(outputMessages.getString("welcome"));

        expected.add(outputMessages.getString("firstName"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("lastName"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("salary"));
        expected.add(outputMessages.getString("invalid"));
        expected.add(outputMessages.getString("salary"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("superRate"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("startDate"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("endDate"));
        expected.add(outputMessages.getString("valid"));

        expected.add(
                        "_____________________________________________" + "\n" +
                        "| Name: Eathan Langford" + "\n" +
                        "| Pay Period: 1 March - 30 March" + "\n" +
                        "| Gross Income: 5004" + "\n" +
                        "| Income Tax: 922" + "\n" +
                        "| Net Income: 4082" + "\n" +
                        "| Paid Super:  450" + "\n" +
                        "_____________________________________________");


        ArrayList<String> actual = output.getOutputCollection();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnValidPayslip_WhenGivenHappyPath() {
        happyOrchestrator.run();
        ArrayList<String> expected = new ArrayList<>();
        expected.add(outputMessages.getString("welcome"));

        expected.add(outputMessages.getString("firstName"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("lastName"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("salary"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("superRate"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("startDate"));
        expected.add(outputMessages.getString("valid"));

        expected.add(outputMessages.getString("endDate"));
        expected.add(outputMessages.getString("valid"));

        expected.add(
                        "_____________________________________________" + "\n" +
                        "| Name: Eathan Langford" + "\n" +
                        "| Pay Period: 1 March - 30 March" + "\n" +
                        "| Gross Income: 5004" + "\n" +
                        "| Income Tax: 922" + "\n" +
                        "| Net Income: 4082" + "\n" +
                        "| Paid Super:  450" + "\n" +
                        "_____________________________________________");


        ArrayList<String> actual = output.getOutputCollection();

        Assert.assertEquals(expected, actual);
    }

}