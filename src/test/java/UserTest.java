import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void shouldCreateUserWithFirstName_WhenConstructed() {
        User actual = new User("Eathan", "Langford", 65000, 9);
        String expected = "Eathan";

        Assert.assertEquals(actual.getName(), expected);
    }
}