public class InputValidator {

    public static boolean isValidDigit(String salary) {
        return salary.chars().allMatch(Character::isDigit);
    }

    public static boolean isValidDateFormat(String startDate) {
        return true;
    }
}
