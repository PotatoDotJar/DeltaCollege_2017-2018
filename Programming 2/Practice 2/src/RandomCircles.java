
// Delta College - CST 283 - Klingler  
// This application draws random circles of random colors.

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random; // Required to enable Random class

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomCircles extends JPanel {

	final static int FRAME_WIDTH = 600;
	final static int FRAME_HEIGHT = 500;

	final static int MIN_DIAMETER = 20;
	final static int MAX_DIAMETER = 100;

	final static int NUMBER_CIRCLES = 20;

	public void paintComponent(Graphics g) {
		// Set up drawing context
		super.paintComponent(g);
		Random randomNumbers = new Random();

		// Variables for random elements
		float redComponent, greenComponent, blueComponent;
		int xPix, yPix, diameter, diameter2;

		// Repeat circle process by given total count
		for (int i = 1; i <= NUMBER_CIRCLES; i++) {
			// Random color
			redComponent = randomNumbers.nextFloat();
			greenComponent = randomNumbers.nextFloat();
			blueComponent = randomNumbers.nextFloat();

			// Random diameter (20...100)
			diameter = randomNumbers.nextInt((MAX_DIAMETER - MIN_DIAMETER) + 1) + MIN_DIAMETER;
			diameter2 = randomNumbers.nextInt((MAX_DIAMETER - MIN_DIAMETER) + 1) + MIN_DIAMETER;

			// Random position (insuring circle stays in range
			xPix = randomNumbers.nextInt(FRAME_WIDTH - diameter);
			yPix = randomNumbers.nextInt(FRAME_HEIGHT - diameter);

			// Draw circle or oval
			g.setColor(new Color(redComponent, greenComponent, blueComponent));
			if (randomNumbers.nextBoolean()) {
				if (randomNumbers.nextBoolean()) {
					g.fillOval(xPix, yPix, diameter, diameter);
					g.setColor(Color.black);
					g.drawOval(xPix, yPix, diameter, diameter);
				} else {
					g.fillOval(xPix, yPix, diameter, diameter2);
					g.setColor(Color.black);
					g.drawOval(xPix, yPix, diameter, diameter2);
				}
				// Draw rectangle or square
			} else {
				if (randomNumbers.nextBoolean()) {
					g.fillRect(xPix, yPix, diameter, diameter2);
					g.setColor(Color.black);
					g.drawRect(xPix, yPix, diameter, diameter2);
				} else {
					g.fillRect(xPix, yPix, diameter, diameter);
					g.setColor(Color.black);
					g.drawRect(xPix, yPix, diameter, diameter);
				}
			}
		}

	}

	public static void main(String args[]) {
		// Instantiate drawing panel
		RandomCircles drawPanel = new RandomCircles();

		// Instantiate application object
		JFrame application = new JFrame();

		// Add drawing panel to application
		application.add(drawPanel);

		// Set application attributes
		application.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		application.setVisible(true);
		application.setTitle("Random Circles");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}