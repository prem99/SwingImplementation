import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ViewAllLocationsPage extends JFrame implements ActionListener {
    private Container north;
    private JLabel title;
    private JPanel titlePanel;
    private JPanel buttonPanel;

    private JButton back;


    ViewAllLocationsPage() {
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
