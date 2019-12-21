import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Richard Nader
 * Class for handling the main program window and adding the panels together
 */
public class MainWindow extends JFrame {

    // Array of check boxes
    private JCheckBox[] checkBoxes;

    // Check box names
    private String[] titles = {"Smiley Face", "House and Pine Tree","Personal Logo",
                               "Fighter Picture"};

    // Panel to display check boxes
    private JPanel checkBoxPanel;

    // Panel for drawing shapes and objects
    private DrawingPane drawingPanel;

    // COnstruct the main window
    public MainWindow() {
        buildCheckBoxPanel();

        // Create the panel for drawing using external object.
        drawingPanel = new DrawingPane(checkBoxes);
        // Add panels to display
        add(checkBoxPanel, BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);
    }

    // Method for building the array of check boxes on the left side of the screen
    private void buildCheckBoxPanel() {
        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(titles.length, 1));
        checkBoxes = new JCheckBox[titles.length];
        // Populate panel with check boxes
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(titles[i]);
            checkBoxes[i].addItemListener(
                    new CheckBoxListener());
            checkBoxes[i].setFont(new Font("SansSeirf", Font.BOLD, 24));
            checkBoxPanel.add(checkBoxes[i]);
        }
    }

    // Private class to listen for changes and update the drawing panel
    private class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            drawingPanel.repaint();
        }
    }

    // Main run method
    public static void main(String args[]) {
        MainWindow application = new MainWindow();
        application.setSize(750, 450);
        application.setVisible(true);
        application.setTitle("Project 10");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}