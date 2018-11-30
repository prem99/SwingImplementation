import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfo {
    public static final Map<String, List<String>> loginInfo = new HashMap<>();

    public static void addNewUser(String name, String email, String password,
                                  String userType) {
        List<String> userInfo = new ArrayList<>();
        userInfo.add(name);
        userInfo.add(password);
        userInfo.add(userType);
        loginInfo.put(email, userInfo);
    }

    public static String attemptLogin(String email, String password) {
        boolean validEmail = false;
        boolean validPassword = false;
        for (String emails : loginInfo.keySet()) {
            if (emails.equals(email)) {
                validEmail = true;
            }
        }
        if (validEmail && password.equals(loginInfo.get(email).get(1))) {
            validPassword = true;
        }
        if (validEmail && validPassword) {
            return email;
        } else {
            return null;
        }
    }

}
