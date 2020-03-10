package User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User actual;

    @Before
    public void setUp() {
        actual  = new User("Eathan", "Langford", "60050", "9", "March 1", "March 30");
    }

    @Test
    public void shouldCreateUserWithFirstName_WhenConstructed() {
        String expected = "Eathan";

        Assert.assertEquals(actual.getFirstName(), expected);
    }
    @Test
    public void shouldCreateUserWithLastName_WhenConstructed() {
        String expected = "Langford";

        Assert.assertEquals(actual.getLastName(), expected);
    }
    @Test
    public void shouldCreateUserWithSalary_WhenConstructed() {
        int expected = 60050;

        Assert.assertEquals(actual.getSalary(), expected);
    }
    @Test
    public void shouldCreateUserWithSuperRate_WhenConstructed() {
        int expected = 9;

        Assert.assertEquals(actual.getSuperRate(), expected);
    }

    @Test
    public void shouldCreateUserWithStartDate_WhenConstructed() {
        String expected = "March 1";

        Assert.assertEquals(actual.getStartDate(), expected);
    }
    @Test
    public void shouldCreateUserWithEndDate_WhenConstructed() {
        String expected = "March 30";

        Assert.assertEquals(actual.getEndDate(), expected);
    }
}