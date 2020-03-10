package User;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DetailParserTest {
@Test
    public void shouldCreateValidUser_WhenParsingDetails() {
    HashMap<String, String> userDetails = new HashMap<>();
    userDetails.put("firstName", "Eathan");
    userDetails.put("lastName", "Langford");
    userDetails.put("salary", "65000");
    userDetails.put("superRate", "9");
    userDetails.put("startDate", "March 1");
    userDetails.put("endDate", "March 30");

    User actual = DetailParser.parseDetailsToUser(userDetails);
    User expected = new User("Eathan", "Langford", "65000", "9", "March 1", "March 30");

    Assert.assertEquals(actual.getFirstName(), expected.getFirstName());
    Assert.assertEquals(actual.getLastName(), expected.getLastName());
    Assert.assertEquals(actual.getSalary(), expected.getSalary());
    Assert.assertEquals(actual.getSuperRate(), expected.getSuperRate());
    Assert.assertEquals(actual.getStartDate(), expected.getStartDate());
    Assert.assertEquals(actual.getEndDate(), expected.getEndDate());
}
}