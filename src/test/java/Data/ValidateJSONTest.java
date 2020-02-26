package Data;

import org.junit.Assert;
import org.junit.Test;

public class ValidateJSONTest {

    @Test
    public void shouldReturnTrueForValidJSON() {
        ValidateJSON validator = new ValidateJSON();
        boolean actual = validator.isValidJSON("./src/main/resources/2017-18_Tax_Data.JSON");

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrue_WhenGivenValidStringNumber() {
        ValidateJSON validator = new ValidateJSON();
        boolean actual = validator.isValidDigit("55");

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalse_WhenGivenInvalidStringNumber() {
        ValidateJSON validator = new ValidateJSON();
        boolean actual = validator.isValidDigit(".55");

        Assert.assertFalse(actual);
    }
    @Test
    public void shouldReturnTrue_WhenGivenValidStringFloat() {
        ValidateJSON validator = new ValidateJSON();
        boolean actual = validator.isValidDigit("0.55");

        Assert.assertTrue(actual);
    }
    @Test
    public void shouldReturnTrue_WhenGivenValidStringNegative() {
        ValidateJSON validator = new ValidateJSON();
        boolean actual = validator.isValidDigit("-55");

        Assert.assertTrue(actual);
    }
    @Test
    public void shouldReturnTrue_WhenGivenZero() {
        ValidateJSON validator = new ValidateJSON();
        boolean actual = validator.isValidDigit("0");

        Assert.assertTrue(actual);
    }


}
