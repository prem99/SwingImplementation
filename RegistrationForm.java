import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame implements ActionListener {

    private Container north;
    private JLabel title;
    private JPanel titlePanel;

    private JTextField name;
    private JPanel namePanel;
    private JLabel nameLabel;

    private JTextField email;
    private JPanel emailPanel;
    private JLabel emailLabel;

    private JPasswordField pass;
    private JPanel passPanel;
    private JLabel passLabel;

    private JComboBox<UserType> dropDown;
    private JPanel typePanel;
    private JLabel typeLabel;

    private JButton register;
    private JButton cancel;
    private JPanel registerPanel;

    RegistrationForm() {
        titlePanel = new JPanel();
        title = new JLabel("Donation Tracker: Registration Form");
        titlePanel.add(title);

        namePanel = new JPanel();
        nameLabel = new JLabel("Name: ");
        name = new JTextField();
        name.setPreferredSize(new Dimension(150,50));
        namePanel.add(nameLabel);
        namePanel.add(name);

        emailPanel = new JPanel();
        emailLabel = new JLabel("Email: ");
        email = new JTextField();
        email.setPreferredSize(new Dimension(150,50));
        emailPanel.add(emailLabel);
        emailPanel.add(email);

        passPanel = new JPanel();
        passLabel = new JLabel("Password: ");
        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(150,50));
        passPanel.add(passLabel);
        passPanel.add(pass);

        typePanel = new JPanel();
        typeLabel = new JLabel("User Type: ");
        dropDown = new JComboBox<>(UserType.values());
        dropDown.setPreferredSize(new Dimension(150,50));
        typePanel.add(typeLabel);
        typePanel.add(dropDown);

        register = new JButton("Register");
        cancel = new JButton("Cancel");
        registerPanel = new JPanel();
        registerPanel.add(cancel);
        registerPanel.add(register);
        register.setActionCommand("register");
        register.addActionListener(this);
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);

        north = getContentPane();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(titlePanel);
        north.add(namePanel);
        north.add(emailPanel);
        north.add(passPanel);
        north.add(typePanel);
        north.add(registerPanel);

        north.setVisible(true);

        this.setSize(600,600);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if ("register".equals(e.getActionCommand())) {
            UserInfo.addNewUser(name.getText(), email.getText(),
                    pass.getSelectedText(),
                    dropDown.getSelectedItem().toString());

            DonationTracker.login();
            this.dispose();
        }
        if ("cancel".equals(e.getActionCommand())) {
            DonationTracker.login();
            this.dispose();
        }
    }
}
