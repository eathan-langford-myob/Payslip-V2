import Utilities.InputValidator;
import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {
    @Test
    public void shouldReturnTrue_ForValidDigit() {
        String salary = "65000";
        Assert.assertTrue(InputValidator.isValidDigit(salary));
    }
    @Test
    public void shouldReturnFalse_ForInvalidDigit() {
        String salary = "65ooo";
        Assert.assertFalse(InputValidator.isValidDigit(salary));
    }
    @Test
    public void shouldReturnTrue_WhenGivenValidDateFormat() {
        String startDate = "1 March";
        Assert.assertTrue(InputValidator.isValidDateFormat(startDate));
    }
    @Test
    public void shouldReturnFalse_WhenGivenValidDateFormat() {
        String startDate = "March1";
        Assert.assertFalse(InputValidator.isValidDateFormat(startDate));
    }
}