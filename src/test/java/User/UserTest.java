package User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User actual;

    @Before
    public void setUp() {
        actual = new User("Eathan", "Langford", 65000, 9);
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
        int expected = 65000;

        Assert.assertEquals(actual.getSalary(), expected);
    }
    @Test
    public void shouldCreateUserWithSuperRate_WhenConstructed() {
        int expected = 9;

        Assert.assertEquals(actual.getSuperRate(), expected);
    }
}