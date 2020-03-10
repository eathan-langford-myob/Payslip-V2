package IO;

public class MockConsoleInputPayslip_sadPath implements IInput {
    private String[] arrayOfUserAnswers = {
            "Eathan",
            "Langford",
            "650ooo",
            "60050",
            "9",
            "1 March",
            "30 March",
    };
    int counter = -1;

    @Override
    public String getInput() {
        counter++;
        return arrayOfUserAnswers[counter];
    }
}