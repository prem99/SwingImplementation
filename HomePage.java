import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
    private Container north;
    private JLabel title;
    private JPanel titlePanel;


    private JButton viewLocations;
    private JButton createAccount;
    private JPanel locationPanel;

    HomePage() {
        titlePanel = new JPanel();
        title = new JLabel("Welcome! ");
        titlePanel.add(title);

        viewLocations = new JButton("View Locations");
        locationPanel = new JPanel();
        locationPanel.add(viewLocations);
        viewLocations.setActionCommand("viewLocations");
        viewLocations.addActionListener(this);

        north = getContentPane();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(titlePanel);
        north.add(locationPanel);

        north.setVisible(true);

        this.setSize(600,600);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if ("viewLocations".equals(e.getActionCommand())) {
            //go to view locations
            this.dispose();
        }
    }
}
