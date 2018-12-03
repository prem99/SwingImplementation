import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Set;

public class ViewAllLocationsPage extends JFrame implements ActionListener {
    private Container north;
    private JLabel title;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;

    private JButton back;


    ViewAllLocationsPage() {
        Set<Location> locations = Location.getLocationList();
        Object[][] data = new Object[locations.size()][3];
        int i = 0;
        System.out.println(Location.locationListToString());
        for (Location l: locations) {
            data[i][0] = l.getName();
            data[i][1] = l.getCoordinates();
            data[i][2] = l.getType();
            i++;
        }
        String[] labels = {"Name", "Coordinates", "Type"};
        JTable table = new JTable(data, labels);
        table.setRowHeight(30);
        table.setRowHeight(20, 60);

        tablePanel = new JPanel();
        tablePanel.add(table);

        titlePanel = new JPanel();
        title = new JLabel("All Locations");
        titlePanel.add(title);


        buttonPanel = new JPanel();
        back = new JButton("Back");
        back.setActionCommand("back");
        back.addActionListener(this);
        buttonPanel.add(back);


        north = getContentPane();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(titlePanel);
        north.add(tablePanel);
        north.add(buttonPanel);

        north.setVisible(true);

        this.setSize(600,600);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if ("back".equals(e.getActionCommand())) {
                DonationTracker.openingScreen();
                this.dispose();
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Failed to read csv file");
        }


    }

}
