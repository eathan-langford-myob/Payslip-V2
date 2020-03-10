package User;

import java.util.HashMap;

public class DetailParser {

    public static User parseDetailsToUser(HashMap<String, String> userDetails) {
        return new User(userDetails.get("firstName"),userDetails.get("lastName"),userDetails.get("salary"),userDetails.get("superRate"),userDetails.get("startDate"), userDetails.get("endDate"));
    }
}
