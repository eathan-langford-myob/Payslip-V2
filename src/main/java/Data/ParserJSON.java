package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ParserJSON {
    private JSONArray file;

    public ParserJSON(String fileLocation) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        file = (JSONArray) parser.parse(new FileReader(fileLocation));
    }

    public boolean isValidJSON() {
            for (Object singleTaxBracket : file)
            {
                JSONObject singleJSONObject = (JSONObject) singleTaxBracket;
                boolean lowerThresholdCheck = isValidDigit(singleJSONObject.get("lowerThreshold").toString());
                boolean upperThresholdCheck = isValidDigit(singleJSONObject.get("upperThreshold").toString());
                boolean perDollar = isValidDigit(singleJSONObject.get("perDollar").toString());
                boolean initialCharge = isValidDigit(singleJSONObject.get("initialCharge").toString());

                if (!lowerThresholdCheck && !upperThresholdCheck && !perDollar && !initialCharge) {
                    return false;
                }
            }
        return true;
    }

    public boolean isValidDigit(String jsonString) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(jsonString).matches();
    }

    public JSONArray getParsed() {
        return file;
    }

    public boolean isSalaryWithinTaxBracket(int salary, JSONObject singleTaxBracket) {
        boolean isMaxUpperThreshold = (Integer.parseInt(singleTaxBracket.get("upperThreshold").toString()) == 0);

        boolean lowerThresholdCheck = salary > Integer.parseInt(singleTaxBracket.get("lowerThreshold").toString());
        boolean upperThresholdCheck = salary < Integer.parseInt(singleTaxBracket.get("upperThreshold").toString()) || isMaxUpperThreshold;

        return lowerThresholdCheck && upperThresholdCheck;
    }
}
