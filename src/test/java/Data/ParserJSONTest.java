package Data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserJSONTest {
    private ParserJSON parser;

    @Before
    public void setUp() throws Exception {
        parser = new ParserJSON(System.getenv("TAX_DATA"));
    }

    @Test
    public void shouldReturnTrueForValidJSON() {
        boolean actual = parser.isValidJSON();

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrue_WhenGivenValidStringNumber() {
        boolean actual = parser.isValidDigit("55");

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalse_WhenGivenInvalidStringNumber() {
        boolean actual = parser.isValidDigit(".55");

        Assert.assertFalse(actual);
    }
    @Test
    public void shouldReturnTrue_WhenGivenValidStringFloat() {
        boolean actual = parser.isValidDigit("0.55");

        Assert.assertTrue(actual);
    }
    @Test
    public void shouldReturnTrue_WhenGivenValidStringNegative() {
        boolean actual = parser.isValidDigit("-55");

        Assert.assertTrue(actual);
    }
    @Test
    public void shouldReturnTrue_WhenGivenZero() {
        boolean actual = parser.isValidDigit("0");

        Assert.assertTrue(actual);
    }


}
