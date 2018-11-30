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

    public static void attemptLogin(String email, String password) {
        for (String emails : loginInfo.keySet()) {
            if (emails.equals(email)) {
                System.out.println("email is correct");
            }
        }
        if (password.equals(loginInfo.get(email).get(1))) {
            System.out.println("password is correct");
        }
    }

}
