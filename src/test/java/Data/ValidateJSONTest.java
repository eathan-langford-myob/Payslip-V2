package Data;

import org.junit.Assert;
import org.junit.Test;

public class ValidateJSONTest {

    @Test
    public void shouldReturnTrueForValidJSON() {
        ValidateJSON validator = new ValidateJSON();
        boolean actual = validator.isValidJSON("2017-18_Tax_Data.JSON");

        Assert.assertTrue(actual);
    }
}
