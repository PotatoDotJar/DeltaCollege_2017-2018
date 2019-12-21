import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {

    // Array for check boxes
    private JCheckBox[] checkBoxArray;

    
    public DrawingPanel(JCheckBox[] cbArray) {
        // Reference the check box array.
        checkBoxArray = cbArray;

        // Set the background color to white.
        setBackground(Color.white);

        // Set the preferred size of the panel
        setPreferredSize(new Dimension(500, 400));
    }

    // paintComponent method
    public void paintComponent(Graphics g) {
        // Call the superclass paintComponent method.
        super.paintComponent(g);

        // Draw the selected shapes.
        
        // Smiley Face
        if (checkBoxArray[0].isSelected()) {
            g.setColor(Color.black);
            g.drawLine(100, 0, 100, 100);
        }
        // House and Pine Tree
        if (checkBoxArray[1].isSelected()) {
            g.setColor(Color.black);
            g.drawRect(100, 150, 250, 150);
        }
        // Personal Logo
        if (checkBoxArray[2].isSelected()) {
            g.setColor(Color.blue);
            g.fillRect(300, 200, 100, 100);
        }
        // Battle Game
        if (checkBoxArray[3].isSelected()) {
            g.setColor(Color.black);
            g.drawOval(40, 155, 75, 50);
        }
    }
}