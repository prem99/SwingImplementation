
public class DonationTracker {

    public static void main(String[] args) {
        login();
    }

    static void login() {
        new LoginForm().setVisible(true);
    }

    static void register() {new RegistrationForm().setVisible(true);}

    static void openingScreen() {new HomePage().setVisible(true);}
}
