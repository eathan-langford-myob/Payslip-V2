package IO;

import java.util.Scanner;

public class IConsoleInput implements IInput {
    private Scanner scanner;

    public IConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
