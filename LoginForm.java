import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private Container north;
    private JLabel title;
    private JPanel titlePanel;

    private JTextField email;
    private JPanel emailPanel;
    private JLabel emailLabel;

    private JPasswordField pass;
    private JPanel passPanel;
    private JLabel passLabel;

    private JButton login;
    private JButton createAccount;
    private JPanel loginPanel;

    LoginForm() {
        titlePanel = new JPanel();
        title = new JLabel("Donation Tracker: Login Form");
        titlePanel.add(title);

        emailPanel = new JPanel();
        emailLabel = new JLabel("Email: ");
        email = new JTextField();
        email.setPreferredSize(new Dimension(300,50));
        emailPanel.add(emailLabel);
        emailPanel.add(email);

        passPanel = new JPanel();
        passLabel = new JLabel("Password: ");
        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(300,50));
        passPanel.add(passLabel);
        passPanel.add(pass);

        login = new JButton("Login");
        createAccount = new JButton("Register");
        loginPanel = new JPanel();
        loginPanel.add(createAccount);
        loginPanel.add(login);
        login.setActionCommand("login");
        login.addActionListener(this);
        createAccount.setActionCommand("createAccount");
        createAccount.addActionListener(this);

        north = getContentPane();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(titlePanel);
        north.add(emailPanel);
        north.add(passPanel);
        north.add(loginPanel);

        north.setVisible(true);

        this.setSize(600,600);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if ("login".equals(e.getActionCommand())) {

        }
        if ("createAccount".equals(e.getActionCommand())) {
            DonationTracker.register();
            this.dispose();
        }
    }
}
