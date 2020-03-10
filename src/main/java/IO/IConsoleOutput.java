package IO;

public class IConsoleOutput implements IOutput{
    @Override
    public void displayOutput(String string) {
        System.out.printf("\n"+string);
    }
}
