import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class HomePage extends JFrame implements ActionListener {
    private Container north;
    private JLabel title;
    private JPanel titlePanel;

    private JButton logOut;
    private JButton viewLocations;
    private JPanel locationPanel;


    HomePage() throws FileNotFoundException {
        readCSVFile();
        titlePanel = new JPanel();
        title = new JLabel("Welcome! ");
        titlePanel.add(title);

        viewLocations = new JButton("View Locations");
        logOut = new JButton("Log out");
        locationPanel = new JPanel();
        locationPanel.add(viewLocations);
        locationPanel.add(logOut);
        viewLocations.setActionCommand("viewLocations");
        logOut.setActionCommand("logOut");
        logOut.addActionListener(this);
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
            DonationTracker.viewAllLocations();
            this.dispose();
        }
        if ("logOut".equals(e.getActionCommand())) {
            //go to login page
            DonationTracker.login();
            this.dispose();
        }
    }

    private void readCSVFile() throws FileNotFoundException {
        InputStream csvStream = new FileInputStream(new File("location_data.csv")) {
        };
        Location.parseCSV(csvStream);
    }
}
