import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class InputValidator {

    public static boolean isValidDigit(String salary) {
        return salary.chars().allMatch(Character::isDigit);
    }

    public static boolean isValidDateFormat(String startDate) {
     String[] splitString = startDate.split(" ");
     try {
         SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM");
         Date output = dateFormat.parse(startDate);
         return true;
     } catch (Exception e) {
        return false;
     }
    }
}
