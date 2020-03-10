package IO;

import java.util.ArrayList;

public class MockOutputCollector implements IOutput{
   ArrayList<String> collectionOfOutput = new ArrayList<>();

    @Override
    public void displayOutput(String string) {
        collectionOfOutput.add(string);
    }

    public ArrayList<String> getOutputCollection() {
        return  collectionOfOutput;
    }
}
