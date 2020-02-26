package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ValidateJSON {
    private JSONParser parser = new JSONParser();
    private JSONArray JSONArray = new JSONArray();
    private JSONObject singleJSONObject = new JSONObject();

    public boolean isValidJSON(String file) {
        try {
            JSONArray = (JSONArray) parser.parse(new FileReader(file));

            for (Object singleTaxBracket : JSONArray)
            {
                singleJSONObject = (JSONObject) singleTaxBracket;
                boolean lowerThresholdCheck = isValidDigit(singleJSONObject.get("lowerThreshold").toString());
                boolean upperThresholdCheck = isValidDigit(singleJSONObject.get("upperThreshold").toString());
                boolean perDollar = isValidDigit(singleJSONObject.get("perDollar").toString());
                boolean initialCharge = isValidDigit(singleJSONObject.get("initialCharge").toString());

                return lowerThresholdCheck && upperThresholdCheck && perDollar && initialCharge;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public boolean isValidDigit(String jsonString) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(jsonString).matches();
    }
}
