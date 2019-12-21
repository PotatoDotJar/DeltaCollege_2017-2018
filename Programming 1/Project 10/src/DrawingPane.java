import javax.swing.*;
import java.awt.*;
/**
 * @author Richard Nader
 * Class for handling the drawing panel and the
 * activation of check boxes to show the different objects
 */
public class DrawingPane extends JPanel {

    // Array for check boxes
    private JCheckBox[] checkBoxArray;
    
    
    public DrawingPane(JCheckBox[] cbArray) {
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
        
    	
        // Smiley Face
        if (checkBoxArray[0].isSelected()) {

            g.setColor(Color.yellow);
            g.fillOval((this.getWidth()/2) - 100, (this.getHeight()/2) - 100, 200, 200);
            
            g.setColor(Color.black);
            g.fillOval((this.getWidth()/2) - 40, (this.getHeight()/2) - 30, 10, 20);
            g.fillOval((this.getWidth()/2) + 30, (this.getHeight()/2) - 30, 10, 20);
            
            int[] smileX = {(this.getWidth()/2)-40, (this.getWidth()/2)-20, (this.getWidth()/2)+20, (this.getWidth()/2)+40};
            int[] smileY = {(this.getHeight()/2)+10, (this.getHeight()/2)+40, (this.getHeight()/2)+40, (this.getHeight()/2)+10};
            g.drawPolygon(smileX, smileY, 4);
        }
        // House and Pine Tree
        if (checkBoxArray[1].isSelected()) {
            g.setColor(Color.black);
            // House base
            g.drawRect(100, 150, 150, 150);
            // Roof
            int[] roofX = {100, 60, (150/2)+100, 290, 250};
            int[] roofY = {150, 150, 60, 150, 150};
            g.drawPolygon(roofX, roofY, 5);
            
            // Window
            g.drawRect(192, 200, 50, 50);
            g.drawLine(192 + 25, 200, 192 + 25, 250);
            g.drawLine(192, 225, 192 + 50, 225);
            
            // Door
            int[] doorX = {110, 160, 160, 110};
            int[] doorY = {290, 290, 190, 190};
            g.drawPolygon(doorX, doorY, 4);
            
            // Tree base
            g.setColor(new Color(86, 49, 0));
            g.fillRect(370, 250, 20, 50);
            
            // Tree top
            g.setColor(new Color(1, 175, 13));
            int[] treeX = {370, 340, 370, 350, 380, 410, 390, 420, 390};
            int[] treeY = {250, 250, 190, 190, 130, 190, 190, 250, 250};
            g.fillPolygon(treeX, treeY, 9);
            
            
        }
        // Personal Logo
        if (checkBoxArray[2].isSelected()) {
        	g.setColor(new Color(33, 33, 33));
        	g.fillOval((this.getWidth()/2)-(300/2), (this.getHeight()/2)-(300/2), 300, 300);
        	g.setColor(Color.DARK_GRAY);
        	g.fillOval((this.getWidth()/2)-(200/2), (this.getHeight()/2)-(200/2), 200, 200);
        	
        	g.setColor(new Color(66, 134, 244));
        	g.setFont(new Font("Segoe UI", Font.BOLD, 180));
        	g.drawString("R", this.getWidth()/4 - 10, 230);
        	g.drawString("N", 210, 300);
        }
        // Battle Game
        if (checkBoxArray[3].isSelected()) {
        	
        	int xOff = (this.getWidth()/2);
        	int yOff = (this.getHeight()/2);
        	
            g.setColor(Color.red);
            g.drawLine(xOff, yOff, xOff, yOff + 50);
            //g.drawRect(xOff-10, yOff-20, 20, 20);
            g.drawRoundRect(xOff-10, yOff-20, 20, 20, 6, 6);
            g.fillOval(xOff-6, yOff-16, 3, 3);
            g.fillOval(xOff+3, yOff-16, 3, 3);
            g.drawLine(xOff-3, yOff-8, xOff+3, yOff-8);
            
            // Arms
            int armAngle = 20;
            g.drawLine(xOff, yOff+12, xOff+ (int) (30*Math.sin(Math.toRadians(armAngle))), yOff+22);
            g.drawLine(xOff, yOff+12, xOff- (int) (30*Math.sin(Math.toRadians(armAngle))), yOff+22);
            
            // Legs
            int legAngle = 30;
            g.drawLine(xOff, yOff+50, xOff+ (int) (27*Math.sin(Math.toRadians(legAngle))), yOff+72);
            g.drawLine(xOff, yOff+50, xOff- (int) (27*Math.sin(Math.toRadians(legAngle))), yOff+72);
            
            g.setColor(Color.orange);
            g.setFont(new Font("Segoe UI", Font.BOLD, 12));
            g.drawString("Bad Guy", xOff -22, yOff-25);
            
        }
    }
}









